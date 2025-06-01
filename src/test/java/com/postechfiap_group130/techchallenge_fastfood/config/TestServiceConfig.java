package com.postechfiap_group130.techchallenge_fastfood.config;

import com.postechfiap_group130.techchallenge_fastfood.domain.ports.in.FindCustomerByCpfUseCase;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.out.CustomerRepository;
import com.postechfiap_group130.techchallenge_fastfood.domain.services.FindCustomerByCpfService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@TestConfiguration
public class TestServiceConfig {
    
    @Bean
    @Primary
    public FindCustomerByCpfUseCase findCustomerByCpfUseCase(CustomerRepository customerRepository) {
        return new FindCustomerByCpfService(customerRepository);
    }
} 