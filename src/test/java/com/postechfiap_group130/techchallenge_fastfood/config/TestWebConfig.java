package com.postechfiap_group130.techchallenge_fastfood.config;

import com.postechfiap_group130.techchallenge_fastfood.adapters.in.web.GlobalExceptionHandler;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@TestConfiguration
@Configuration
@ComponentScan(basePackages = {
    "com.postechfiap_group130.techchallenge_fastfood.adapters.in.web",
    "com.postechfiap_group130.techchallenge_fastfood.domain.validation"
})
public class TestWebConfig {
    
    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }
} 