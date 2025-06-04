package com.postechfiap_group130.techchallenge_fastfood.adapters.in.rest.controller;

import com.postechfiap_group130.techchallenge_fastfood.application.dtos.OrderRequestDto;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.Order;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.in.FakeCheckoutUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkout")
public class OrderController {

    private final FakeCheckoutUseCase fakeCheckoutUseCase;

    public OrderController(final FakeCheckoutUseCase fakeCheckoutUseCase) {
        this.fakeCheckoutUseCase = fakeCheckoutUseCase;
    }

    @PostMapping("/fake-checkout")
    public ResponseEntity<Order> fakeCheckout(@RequestBody OrderRequestDto orderRequestDto) {

         Order order = fakeCheckoutUseCase.execute(orderRequestDto.toDomain());

        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }
}
