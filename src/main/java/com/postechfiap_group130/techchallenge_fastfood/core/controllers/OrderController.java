package com.postechfiap_group130.techchallenge_fastfood.core.controllers;

import com.postechfiap_group130.techchallenge_fastfood.core.usecases.GetOrdersUseCase;
import com.postechfiap_group130.techchallenge_fastfood.core.dtos.OrderDto;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.Order;
import com.postechfiap_group130.techchallenge_fastfood.core.gateways.OrderGateway;
import com.postechfiap_group130.techchallenge_fastfood.core.interfaces.DataSource;
import com.postechfiap_group130.techchallenge_fastfood.core.presenters.OrderPresenter;

import java.util.List;

public class OrderController {

    private final DataSource dataSource;

    public OrderController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<OrderDto> getAllOrders() {
        OrderGateway orderGateway = new OrderGateway(dataSource);
        GetOrdersUseCase getOrdersUseCase = new GetOrdersUseCase(orderGateway);

        List<Order> listOrders = getOrdersUseCase.execute();

        return OrderPresenter.toDto(listOrders);
    }
}
