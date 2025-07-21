package com.postechfiap_group130.techchallenge_fastfood.application.useCases;

import com.postechfiap_group130.techchallenge_fastfood.core.entities.Order;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.in.GetOrdersUseCase;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.out.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetOrdersUseCaseImpl implements GetOrdersUseCase {

    private final OrderRepository orderRepository;

    GetOrdersUseCaseImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> execute() {
        return orderRepository.findAll();
    };
}
