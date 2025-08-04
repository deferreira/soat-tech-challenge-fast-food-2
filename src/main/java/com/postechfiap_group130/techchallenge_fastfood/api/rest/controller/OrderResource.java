package com.postechfiap_group130.techchallenge_fastfood.api.rest.controller;

import com.postechfiap_group130.techchallenge_fastfood.api.data.DataRepository;
import com.postechfiap_group130.techchallenge_fastfood.application.dtos.OrderRequestDto;
import com.postechfiap_group130.techchallenge_fastfood.core.controllers.OrderController;
import com.postechfiap_group130.techchallenge_fastfood.core.dtos.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderResource {

    private final DataRepository dataRepository;

    public OrderResource(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @PostMapping("/checkout")
    public ResponseEntity<OrderDto> checkout(@RequestBody OrderRequestDto orderRequestDto) {
        OrderController orderController = new OrderController(dataRepository);

        OrderDto order = orderController.checkout(orderRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getOrders() {
        OrderController orderController = new OrderController(dataRepository);

        List<OrderDto> ordersList = orderController.getAllOrders();

        return ResponseEntity.status(HttpStatus.OK).body(ordersList);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long orderId) {
        // TODO: implement id validation
        OrderController orderController = new OrderController(dataRepository);
        OrderDto response = orderController.findById(orderId);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }

    @PatchMapping("/{orderId}/status/{orderStatus}")
    public ResponseEntity<OrderDto> updateStatus(@PathVariable Long orderId, @PathVariable String orderStatus) {
        OrderController orderController = new OrderController(dataRepository);

        OrderDto response = orderController.updateStatus(orderId, orderStatus);

        return response != null ? ResponseEntity.ok(response) : ResponseEntity.notFound().build();
    }
}
