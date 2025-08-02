package com.postechfiap_group130.techchallenge_fastfood.core.usecases;

import com.postechfiap_group130.techchallenge_fastfood.core.entities.Order;
import com.postechfiap_group130.techchallenge_fastfood.core.gateways.OrderGateway;

public class UpdateOrderStatusUseCase {

    private final OrderGateway orderGateway;

    public UpdateOrderStatusUseCase(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    public void updateOrderStatus(Long orderId, String orderStatus) {

        Order order = orderGateway.getOrderById(orderId);

        order.updateStatus();


    }
}
