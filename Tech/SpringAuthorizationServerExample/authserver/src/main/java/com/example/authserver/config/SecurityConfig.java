package com.example.authserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
    @Bean
    InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        var one = User.withDefaultPasswordEncoder().roles("admin").username("user1").password("1234").build();
        var two = User.withDefaultPasswordEncoder().roles("user").username("user2").password("1234").build() ;
        return new InMemoryUserDetailsManager(one, two);
    }
}
