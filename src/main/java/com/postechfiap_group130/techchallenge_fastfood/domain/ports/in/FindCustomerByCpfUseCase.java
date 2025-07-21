package com.postechfiap_group130.techchallenge_fastfood.domain.ports.in;

import com.postechfiap_group130.techchallenge_fastfood.core.entities.Customer;

public interface FindCustomerByCpfUseCase {
    Customer findByCpf(String cpf);
} 