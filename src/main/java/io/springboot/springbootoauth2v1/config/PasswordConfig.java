package io.springboot.springbootoauth2v1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordConfig {
    @Bean
    private PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder(10);
    }
}
