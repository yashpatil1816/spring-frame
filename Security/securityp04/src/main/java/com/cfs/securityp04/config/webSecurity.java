package com.cfs.securityp04.config;

import com.cfs.securityp04.Service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class webSecurity {


    private final CustomUserDetailService customUserDetailService;

    public webSecurity(CustomUserDetailService customUserDetailService) {
        this.customUserDetailService = customUserDetailService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
        http
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth->auth
                .requestMatchers("/api","/api/public","/api/adduser").permitAll()
                .requestMatchers("/api/user").hasRole("USER")
                .requestMatchers("/api/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
        ).httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        AuthenticationManager authenticationManager = config.getAuthenticationManager();
        System.out.println("AuthenticationManager called.......");
        return authenticationManager;
    }


    @Bean
    public PasswordEncoder passwordEncoder()
    {
        BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println("passwordEncoder method called....");
        return cryptPasswordEncoder;
    }
}

