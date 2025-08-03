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

    private int getStatusPriority(String status) {
        return switch (status.toUpperCase()) {
            case "PRONTO" -> 1;
            case "EM_PREPARACAO" -> 2;
            case "RECEBIDO" -> 3;
            default -> 99; // qualquer outro status vem por último
        };
    }

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

        List<OrderDto> sortedFilteredOrders = ordersList.stream()
                .filter(order -> order.getStatus() != null && !order.getStatus().equalsIgnoreCase("FINALIZADO"))
                .sorted((o1, o2) -> {
                    int statusComparison = Integer.compare(getStatusPriority(o1.getStatus()), getStatusPriority(o2.getStatus()));
                    if (statusComparison != 0) return statusComparison;

                    return o1.getCreatedAt().compareTo(o2.getCreatedAt());
                })
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(sortedFilteredOrders);
    }
}
