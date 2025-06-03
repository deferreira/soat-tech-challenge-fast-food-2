package com.postechfiap_group130.techchallenge_fastfood.application.useCases;

import com.postechfiap_group130.techchallenge_fastfood.domain.ports.in.FindCustomerByCpfUseCase;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.Customer;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.out.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindCustomerByCpfUseCaseImpl implements FindCustomerByCpfUseCase {

    private final CustomerRepository customerRepository;

    @Override
    public Customer findByCpf(String cpf) {
        return customerRepository.findByCpf(cpf);
    }
} 