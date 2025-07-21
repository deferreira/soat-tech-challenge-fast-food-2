package com.postechfiap_group130.techchallenge_fastfood.core.interfaces;

import com.postechfiap_group130.techchallenge_fastfood.core.dtos.CustomerDto;

public interface DataSource {
    void save(CustomerDto customerDto);

    boolean existsByEmailOrCpf(String email, String cpf);

    CustomerDto findByCpf(String cpf);
}
