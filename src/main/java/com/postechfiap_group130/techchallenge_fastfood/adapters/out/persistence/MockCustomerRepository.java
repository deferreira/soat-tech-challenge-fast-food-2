package com.postechfiap_group130.techchallenge_fastfood.adapters.out.persistence;

import com.postechfiap_group130.techchallenge_fastfood.domain.model.Customer;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.out.CustomerRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class MockCustomerRepository implements CustomerRepository {

    @Override
    public Customer findByCpf(String cpf) {
        // Simula um cliente de exemplo
        return Customer.builder()
                .id("1")
                .name("João da Silva")
                .cpf(cpf)
                .email("joao.silva@email.com")
                .build();
    }
} 