package com.postechfiap_group130.techchallenge_fastfood.api.data;

import com.postechfiap_group130.techchallenge_fastfood.core.entities.Customer;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.out.CustomerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJpaRepository customerJpaRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomerRepositoryImpl(CustomerJpaRepository customerJpaRepository, PasswordEncoder passwordEncoder) {
        this.customerJpaRepository = customerJpaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void save(Customer customer) {
        String encryptedPassword = passwordEncoder.encode(customer.getPassword());

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customer.getName());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setPassword(encryptedPassword);
        customerEntity.setCpf(customer.getCpf());

        customerJpaRepository.save(customerEntity);
    }

    @Override
    public boolean existsByEmailOrCpf(String email, String cpf) {

        return customerJpaRepository.existsByEmailOrCpf(email, cpf);
    }

    @Override
    public Customer findByCpf(String cpf) {
        CustomerEntity entity = customerJpaRepository.findByCpf(cpf);
        if (entity == null) return null;

        Customer customer = new Customer(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getCpf());

        return customer;
    }
}
