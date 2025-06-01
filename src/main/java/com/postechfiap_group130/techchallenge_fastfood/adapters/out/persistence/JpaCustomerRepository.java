package com.postechfiap_group130.techchallenge_fastfood.adapters.out.persistence;

import com.postechfiap_group130.techchallenge_fastfood.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCustomerRepository extends JpaRepository<Customer, String> {
    Customer findByCpf(String cpf);
} 