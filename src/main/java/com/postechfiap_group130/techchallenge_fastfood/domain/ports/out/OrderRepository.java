package com.postechfiap_group130.techchallenge_fastfood.domain.ports.out;

import com.postechfiap_group130.techchallenge_fastfood.domain.model.Order;

import java.util.List;

public interface OrderRepository {
    Order save(Order order);

    List<Order> findAll();
}
