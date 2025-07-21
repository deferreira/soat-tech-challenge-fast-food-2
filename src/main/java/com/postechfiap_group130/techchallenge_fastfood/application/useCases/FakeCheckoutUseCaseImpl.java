package com.postechfiap_group130.techchallenge_fastfood.application.useCases;

import com.postechfiap_group130.techchallenge_fastfood.core.entities.Order;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.in.FakeCheckoutUseCase;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.out.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FakeCheckoutUseCaseImpl implements FakeCheckoutUseCase {

    private final OrderRepository orderRepository;

    public FakeCheckoutUseCaseImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order execute(final Order order) {

        order.setOrderDate(LocalDateTime.now());
        return orderRepository.save(order);
    }

}
