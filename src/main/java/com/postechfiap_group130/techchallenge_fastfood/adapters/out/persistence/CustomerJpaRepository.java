package com.postechfiap_group130.techchallenge_fastfood.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {

    boolean existsByEmailOrCpf(String email, String cpf);

    CustomerEntity findByCpf(String cpf);
}
