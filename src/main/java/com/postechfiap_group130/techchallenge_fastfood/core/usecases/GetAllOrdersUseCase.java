package com.postechfiap_group130.techchallenge_fastfood.core.usecases;

import com.postechfiap_group130.techchallenge_fastfood.core.dtos.OrderDto;

import java.util.Comparator;
import java.util.List;

public class GetAllOrdersUseCase {

    public List<OrderDto> execute(List<OrderDto> allOrders) {
        return allOrders.stream()
                .filter(order -> order.getStatus() != null && !order.getStatus().equalsIgnoreCase("FINALIZADO"))
                .sorted(Comparator
                        .comparing((OrderDto o) -> getStatusPriority(o.getStatus()))
                        .thenComparing(OrderDto::getCreatedAt))
                .toList();
    }

    private int getStatusPriority(String status) {
        return switch (status.toUpperCase()) {
            case "PRONTO" -> 1;
            case "EM_PREPARACAO" -> 2;
            case "RECEBIDO" -> 3;
            default -> 99;
        };
    }
}
