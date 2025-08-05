package com.postechfiap_group130.techchallenge_fastfood.core.usecases;

import com.postechfiap_group130.techchallenge_fastfood.api.rest.dto.request.OrderRequestDto;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.Order;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.OrderItem;
import com.postechfiap_group130.techchallenge_fastfood.core.gateways.OrderGateway;

import java.util.List;
import java.util.stream.Collectors;

public class CreateOrderUseCase {

    private final OrderGateway orderGateway;

    public CreateOrderUseCase(OrderGateway orderGateway) {
        this.orderGateway = orderGateway;
    }

    public Order execute(OrderRequestDto orderRequestDto) {

        List<OrderItem> items = orderRequestDto.getItems().stream()
                .map(item -> new OrderItem(item.productId(), item.quantity(), item.price()))
                .collect(Collectors.toList());

        Order newOrder = new Order(items);

        Order savedOrder = orderGateway.save(newOrder);

        return savedOrder;
    }
}
