package com.pucpr.exercicio;

import org.hibernate.dialect.Database;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterApiChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(auth -> auth
                //.anyRequest().authenticated()
                .requestMatchers(HttpMethod.POST,"api/**").authenticated()
                .requestMatchers(HttpMethod.GET,"api/**").authenticated()
                .requestMatchers(HttpMethod.POST,"user/**").permitAll()
                .requestMatchers(HttpMethod.GET,"user/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET,"exercicio/hello").permitAll()
                .anyRequest().authenticated()
        )
                .httpBasic(withDefaults());
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource database){
        return new JdbcUserDetailsManager(database);
    }
    /*public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails admin = org.springframework.security.
                core.userdetails.User.withDefaultPasswordEncoder()
                .username("admin")
                .password("password")
                .roles("ADMIN","USER")
                .build();

        UserDetails user = org.springframework.security.
                core.userdetails.User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user,admin);
    }*/
}
