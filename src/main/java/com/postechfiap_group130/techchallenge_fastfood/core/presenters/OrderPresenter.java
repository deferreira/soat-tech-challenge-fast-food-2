package com.postechfiap_group130.techchallenge_fastfood.core.presenters;

import com.postechfiap_group130.techchallenge_fastfood.core.dtos.OrderDto;
import com.postechfiap_group130.techchallenge_fastfood.core.dtos.OrderItemDto;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.Order;

import java.math.BigDecimal;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class OrderPresenter {

    public static List<OrderDto> toDto(List<Order> listOrder) {
        List<OrderDto> orderDtoList = listOrder.stream()
                .map((order -> new OrderDto(
                        order.getId(),
                        order.getOrderDate(),
                        order.getOrderStatus(),
                        List.of(),
                        order.getTotal(),
                        order.getPaymentId())))
                .toList();
        return orderDtoList;
    }

    public static OrderDto toDto(Order order) {
        List<OrderItemDto> orderItemDtoList = order.getItems().stream()
                .map(orderItem -> {
                    return new OrderItemDto(
                        orderItem.getId(),
                        orderItem.getProductId(),
                        orderItem.getQuantity(),
                        orderItem.getPrice()
                    );
                })
                .toList();
        return new OrderDto(
                order.getId(),
                order.getOrderDate(),
                order.getOrderStatus(),
                orderItemDtoList,
                order.getTotal(),
                order.getPaymentId());
    }
}
