package com.example.blogback.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //웹 보안 활성화 spring security 이용해서
public class SecurityConfig {

    @Bean
//    securityFilterChain 스프링 시큐리티 설정 파일, 인증 인가 등 엮여있음
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    전체 요청에 접근할 수 있도록 하는 코드(별도의 인증 없이 모든 서비스 이용할 수 있게)
        http
                .csrf(AbstractHttpConfigurer::disable);
        return http.authorizeHttpRequests(auth->auth.anyRequest().permitAll()).build();

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}