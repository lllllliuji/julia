package com.lzw.julia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);

        // 基于http请求的授权配置
        // 放行/huoying/login请求，其他请求都需要认证
        http.authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                        .requestMatchers("/huoying/**").hasRole("Ninja")
                        .requestMatchers("/huoying/shou-li-jian").hasAnyRole("Ninja", "Akatsuki")
//                .requestMatchers("/huoying/xie-lun-yan").hasAuthority("xie-lun-yan")
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/index").permitAll()
                        .anyRequest().authenticated()
        );

        // 基于表单登录
        http.formLogin(formLogin ->
                formLogin
                        .loginPage("/login_page").permitAll() // 访问需要登录的资源跳转到自定义登录页面，获取登录页面的接口
                        .loginProcessingUrl("/login") // 这个接口不用实现，spring security会把对这个接口的访问当作认证流程来处理
                        .defaultSuccessUrl("/index") // 登录成功自动跳转到这个url
                        .usernameParameter("username") // 用户名
                        .passwordParameter("password") // 密码
        );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails naruto = User
                .withUsername("naruto")
                .password("$2a$10$09f0VDkl9sXcXShAtDmWsefH2ZWXDyTreFhxTjHmTkEWp2r48ku5u")
                .roles("USER", "Ninja", "RenZhuLi")
//                .authorities("luo-xuan-wan", "xian-ren") // roles和authorities会互相覆盖权限，巨坑！
                .build();
        UserDetails sasuke = User
                .withUsername("sasuke")
                .password("$2a$10$WcPFSaAKIYfb9YmLPw/RTOUAYaZQ8cD1IZB8Tc2cl0Ng/aVw/8aWi")
                .roles("USER", "Ninja")
//                .authorities("qian-niao", "xie-lun-yan")
                .build();
        UserDetails pain = User
                .withUsername("pain")
                .password("$2a$10$I59VL/fdk2.X4hiTiq86UejnfISeXnW0h8HUyikcBX9UbBKX1nO1y")
                .roles("USER", "Akatsuki")
//                .authorities("shen-luo-tian-zheng")
                .build();
        UserDetails luffy = User
                .withUsername("luffy")
                .password("$2a$10$Qt6vBvU6f5H5K25TI0KYjeR4iOvh.w5f.9WB/CNiUfmYJ/D/hQAlS")
                .roles("USER", "HaiZei")
                .build();
        return new InMemoryUserDetailsManager(naruto, sasuke, pain, luffy);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
