package com.lzw.julia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails naruto = User.withUsername("naruto").password("$2a$10$09f0VDkl9sXcXShAtDmWsefH2ZWXDyTreFhxTjHmTkEWp2r48ku5u").roles("USER").build();
        UserDetails sasuke = User.withUsername("sasuke").password("$2a$10$WcPFSaAKIYfb9YmLPw/RTOUAYaZQ8cD1IZB8Tc2cl0Ng/aVw/8aWi").roles("USER").build();
        UserDetails liuji = User.withUsername("liuji").password("{noop}123456").roles("USER").build();
        return new InMemoryUserDetailsManager(naruto, sasuke, liuji);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
