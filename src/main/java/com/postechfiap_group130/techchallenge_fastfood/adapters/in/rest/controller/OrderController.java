package com.postechfiap_group130.techchallenge_fastfood.adapters.in.rest.controller;

import com.postechfiap_group130.techchallenge_fastfood.application.dtos.OrderRequestDto;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.Order;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.in.FakeCheckoutUseCase;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.in.GetOrdersUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final FakeCheckoutUseCase fakeCheckoutUseCase;
    private final GetOrdersUseCase getOrdersUseCase;

    public OrderController(final FakeCheckoutUseCase fakeCheckoutUseCase, GetOrdersUseCase getOrdersUseCase) {
        this.fakeCheckoutUseCase = fakeCheckoutUseCase;
        this.getOrdersUseCase = getOrdersUseCase;
    }

    @PostMapping("/fake-checkout")
    public ResponseEntity<Order> fakeCheckout(@RequestBody OrderRequestDto orderRequestDto) {

         Order order = fakeCheckoutUseCase.execute(orderRequestDto.toDomain());

        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders() {

        List<Order> ordersList = getOrdersUseCase.execute();

        return ResponseEntity.status(HttpStatus.CREATED).body(ordersList);
    }
}
