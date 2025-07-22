package com.postechfiap_group130.techchallenge_fastfood.api.rest.controller;

import com.postechfiap_group130.techchallenge_fastfood.api.data.DataRepository;
import com.postechfiap_group130.techchallenge_fastfood.application.dtos.OrderRequestDto;
import com.postechfiap_group130.techchallenge_fastfood.core.controllers.OrderController;
import com.postechfiap_group130.techchallenge_fastfood.core.dtos.OrderDto;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.Order;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.in.FakeCheckoutUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderResource {

    private final FakeCheckoutUseCase fakeCheckoutUseCase;

    private final DataRepository dataRepository;

    public OrderResource(DataRepository dataRepository, FakeCheckoutUseCase fakeCheckoutUseCase) {
        this.dataRepository = dataRepository;
        this.fakeCheckoutUseCase = fakeCheckoutUseCase;
    }

    //Falta refatorar este fluxo
    @PostMapping("/fake-checkout")
    public ResponseEntity<Order> fakeCheckout(@RequestBody OrderRequestDto orderRequestDto) {

         Order order = fakeCheckoutUseCase.execute(orderRequestDto.toDomain());

        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getOrders() {
        OrderController orderController = new OrderController(dataRepository);

        List<OrderDto> ordersList = orderController.getAllOrders();

        return ResponseEntity.status(HttpStatus.OK).body(ordersList);
    }
}
