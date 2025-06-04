package com.postechfiap_group130.techchallenge_fastfood.domain.ports.in;

import com.postechfiap_group130.techchallenge_fastfood.domain.model.Order;

import java.util.List;

public interface GetOrdersUseCase {
    List<Order> execute();
}
