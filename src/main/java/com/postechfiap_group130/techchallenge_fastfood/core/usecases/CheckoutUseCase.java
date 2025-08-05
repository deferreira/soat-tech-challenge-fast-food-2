package com.postechfiap_group130.techchallenge_fastfood.core.usecases;

import com.postechfiap_group130.techchallenge_fastfood.api.rest.dto.request.OrderRequestDto;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.Order;
import com.postechfiap_group130.techchallenge_fastfood.core.gateways.OrderGateway;

public class CheckoutUseCase {

    private final OrderGateway orderGateway;

    public CheckoutUseCase(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    public Order execute(OrderRequestDto orderRequestDto) {
        CreateOrderUseCase createOrderUseCase = new CreateOrderUseCase(orderGateway); 

        //Chama o useCase para criar a order
        Order order = createOrderUseCase.execute(orderRequestDto);

        return order;
    }
}
