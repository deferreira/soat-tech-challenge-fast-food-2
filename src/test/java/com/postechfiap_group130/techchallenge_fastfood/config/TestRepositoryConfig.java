package com.postechfiap_group130.techchallenge_fastfood.config;

import com.postechfiap_group130.techchallenge_fastfood.domain.ports.out.CustomerRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.mockito.Mockito;

@TestConfiguration
public class TestRepositoryConfig {
    
    @Bean
    @Primary
    public CustomerRepository customerRepository() {
        return Mockito.mock(CustomerRepository.class);
    }
} 