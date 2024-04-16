package com.pucpr.exercicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    @Order(1)
    public SecurityFilterChain filterApiChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.GET,"api/cart").denyAll()
        );
        return http.build();
    }
    
    @Bean
    @Order(2)
    public SecurityFilterChain filterExercicioChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.GET,"exercicio/hello").denyAll()
        );
        return http.build();
    }
}
