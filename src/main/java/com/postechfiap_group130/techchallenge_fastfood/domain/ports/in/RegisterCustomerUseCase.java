package com.postechfiap_group130.techchallenge_fastfood.domain.ports.in;

import com.postechfiap_group130.techchallenge_fastfood.domain.model.Customer;

public interface RegisterCustomerUseCase {

    void execute(Customer customer);
}
