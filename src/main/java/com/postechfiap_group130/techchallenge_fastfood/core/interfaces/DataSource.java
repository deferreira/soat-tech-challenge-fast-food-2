package com.postechfiap_group130.techchallenge_fastfood.core.interfaces;

import com.postechfiap_group130.techchallenge_fastfood.core.dtos.CustomerDto;
import com.postechfiap_group130.techchallenge_fastfood.core.dtos.OrderDto;

import java.util.List;

public interface DataSource {
    void save(CustomerDto customerDto);

    boolean existsByEmailOrCpf(String email, String cpf);

    CustomerDto findByCpf(String cpf);

    List<OrderDto> getAllOrders();
}
