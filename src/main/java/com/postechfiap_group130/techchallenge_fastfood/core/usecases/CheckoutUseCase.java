package com.postechfiap_group130.techchallenge_fastfood.core.usecases;

import com.postechfiap_group130.techchallenge_fastfood.application.dtos.OrderRequestDto;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.Order;
import com.postechfiap_group130.techchallenge_fastfood.core.gateways.OrderGateway;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.in.FakeCheckoutUseCase;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.out.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

public class CheckoutUseCase {

    private final OrderGateway orderGateway;

    public CheckoutUseCase(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    public Order execute(OrderRequestDto orderRequestDto) {
        CreateOrderUseCase createOrderUseCase = new CreateOrderUseCase(orderGateway);

        //Chama o useCase para criar a order
        createOrderUseCase.execute();

        //Depois

        return null;
    }

}
