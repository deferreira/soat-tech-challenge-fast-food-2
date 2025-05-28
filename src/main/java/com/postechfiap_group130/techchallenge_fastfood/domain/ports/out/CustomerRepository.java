package com.postechfiap_group130.techchallenge_fastfood.domain.ports.out;

import com.postechfiap_group130.techchallenge_fastfood.domain.model.Customer;

public interface CustomerRepository {

    void save(Customer customer);
}
