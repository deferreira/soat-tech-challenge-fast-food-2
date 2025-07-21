package com.postechfiap_group130.techchallenge_fastfood.api.data;

import com.postechfiap_group130.techchallenge_fastfood.core.dtos.CustomerDto;
import com.postechfiap_group130.techchallenge_fastfood.core.interfaces.DataSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class DataRepository implements DataSource {

    private final CustomerJpaRepository customerJpaRepository;
    private final PasswordEncoder passwordEncoder;

    public DataRepository(CustomerJpaRepository customerJpaRepository, PasswordEncoder passwordEncoder) {
        this.customerJpaRepository = customerJpaRepository;
        this.passwordEncoder = passwordEncoder;
    }
    //Recebe um DTO e transforma para Entity do JPA para salvar
    //Devolve um DTO
    @Override
    public void save(CustomerDto customerDto) {
        String encryptedPassword = passwordEncoder.encode(customerDto.password());

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customerDto.id());
        customerEntity.setName(customerDto.name());
        customerEntity.setEmail(customerDto.email());
        customerEntity.setPassword(encryptedPassword);
        customerEntity.setCpf(customerDto.cpf());

        customerJpaRepository.save(customerEntity);

    }

    @Override
    public boolean existsByEmailOrCpf(String email, String cpf) {

        return customerJpaRepository.existsByEmailOrCpf(email, cpf);
    }

    @Override
    public CustomerDto findByCpf(String cpf) {
        CustomerEntity entity = customerJpaRepository.findByCpf(cpf);
        if (entity == null) return null;

        CustomerDto customerDto = new CustomerDto(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getCpf(),
                entity.getPassword());

        return customerDto;
    }
}
