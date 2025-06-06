package com.lzw.julia.config;

import com.lzw.julia.security.JuliaAccessDeniedHandler;
import com.lzw.julia.security.JuliaAuthenticationEntryPoint;
import com.lzw.julia.security.JuliaAuthorizationManager;
import com.lzw.julia.security.JwtAuthenticationFilter;
import com.lzw.julia.util.CaffeineUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService sysUserDetailsService;

    @Autowired
    private CaffeineUtils caffeineUtils;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);

        // 基于http请求的授权配置
        http.authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                .requestMatchers("/index", "/auth/login").permitAll()
                .anyRequest().access(JuliaAuthorizationManager.builder().caffeineUtils(caffeineUtils).build())
        );
        http.exceptionHandling(exception -> exception
                .accessDeniedHandler(new JuliaAccessDeniedHandler()) // 授权
                .authenticationEntryPoint(new JuliaAuthenticationEntryPoint()) // 认证
        );
        // 禁用表单登录
        http.formLogin(AbstractHttpConfigurer::disable);
        http.httpBasic(AbstractHttpConfigurer::disable);

        // 无状态管理，禁用session，采用jwt
        http.sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        // jwt过滤器
        http.addFilterBefore(JwtAuthenticationFilter.builder().caffeineUtils(caffeineUtils).build(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(PasswordEncoder passwordEncoder) {
        // 可关联多个AuthenticationProvider，暂时只提供一个。
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(sysUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder); // 关联密码加密器
        return new ProviderManager(provider);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
