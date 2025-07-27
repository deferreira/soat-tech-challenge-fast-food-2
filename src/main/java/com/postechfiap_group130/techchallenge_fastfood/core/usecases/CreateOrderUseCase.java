package com.postechfiap_group130.techchallenge_fastfood.core.usecases;

import com.postechfiap_group130.techchallenge_fastfood.core.entities.Order;
import com.postechfiap_group130.techchallenge_fastfood.core.gateways.OrderGateway;

public class CreateOrderUseCase {

    private final OrderGateway orderGateway;

    public CreateOrderUseCase(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    public Order execute() {

        Order newOrder = new Order();
//
        Order savedOrder = orderGateway.save(newOrder);

        return savedOrder;
    }

}
