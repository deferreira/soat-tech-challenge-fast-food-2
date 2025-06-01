package com.postechfiap_group130.techchallenge_fastfood.adapters.out.persistence;

import com.postechfiap_group130.techchallenge_fastfood.domain.model.Customer;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.out.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    private final JpaCustomerRepository jpaCustomerRepository;

    @Override
    public Customer findByCpf(String cpf) {
        return jpaCustomerRepository.findByCpf(cpf);
    }
} 