package com.postechfiap_group130.techchallenge_fastfood.core.presenters;

import com.postechfiap_group130.techchallenge_fastfood.core.dtos.OrderDto;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.Order;

import java.util.List;

public class OrderPresenter {

    public static List<OrderDto> toDto(List<Order> listOrder) {
        List<OrderDto> orderDtoList = listOrder.stream()
                .map((order -> new OrderDto(
                        order.getId(),
                        order.getOrderDate(),
                        order.getOrderStatus(),
                        order.getTotal(),
                        order.getPaymentId())))
                .toList();
        return orderDtoList;
    }

    public static OrderDto toDto(Order order) {
        return new OrderDto(
                order.getId(),
                order.getOrderDate(),
                order.getOrderStatus(),
                order.getTotal(),
                order.getPaymentId());
    }
}
