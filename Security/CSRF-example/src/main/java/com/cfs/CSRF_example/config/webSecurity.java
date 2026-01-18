package com.cfs.CSRF_example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;

@Service
@EnableWebSecurity

public class webSecurity {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http){
        http
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth->auth
                .requestMatchers("/api","/api/public","/api/adduser").permitAll()
                .anyRequest().authenticated()
        ).httpBasic(Customizer.withDefaults());

        return http.build();
    }

}
