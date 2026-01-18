package com.cfs.security_P02.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityConfig {

    @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http){
http.authorizeHttpRequests(auth->auth
        .requestMatchers("/bank","/bank/about","/bank/contactUs").permitAll()
        .requestMatchers("/bank/transfer","/bank/admin").authenticated()
).httpBasic(Customizer.withDefaults());

return http.build();
}

}
