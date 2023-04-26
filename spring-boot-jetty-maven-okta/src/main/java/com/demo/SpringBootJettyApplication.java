package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@SpringBootApplication
public class SpringBootJettyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJettyApplication.class, args);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authz) -> {
            authz.anyRequest().permitAll();
        });
        http.oauth2ResourceServer().jwt();

        return http.build();
    }

}
