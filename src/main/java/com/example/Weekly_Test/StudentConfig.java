package com.example.Weekly_Test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    public Student student() {
        return new Student("Rhea", 23);
    }
    @Bean
    public MailService mailService() {
        return new MailService();
    }
}
