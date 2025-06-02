package com.postechfiap_group130.techchallenge_fastfood.application.useCases;

import com.postechfiap_group130.techchallenge_fastfood.domain.model.Customer;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.in.RegisterCustomerUseCase;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.out.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterCustomerUseCaseImpl implements RegisterCustomerUseCase {

    private final CustomerRepository customerRepository;

    public RegisterCustomerUseCaseImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void execute(Customer customer) {

        //Adicionar validacao de negocio

        customerRepository.save(customer);
    };
}
