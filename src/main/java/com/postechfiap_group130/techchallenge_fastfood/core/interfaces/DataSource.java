package com.postechfiap_group130.techchallenge_fastfood.core.interfaces;

import com.postechfiap_group130.techchallenge_fastfood.core.dtos.CustomerDto;
import com.postechfiap_group130.techchallenge_fastfood.core.dtos.OrderDto;

import java.util.List;

public interface DataSource {
    void saveCustomer(CustomerDto customerDto);

    boolean existsCustomerByEmailOrCpf(String email, String cpf);

    CustomerDto findCustomerByCpf(String cpf);

    List<OrderDto> getAllOrders();

    OrderDto saveOrder(OrderDto orderDto);

    OrderDto getOrderById(Long id);

}
