package com.postechfiap_group130.techchallenge_fastfood.core.dtos;

import com.postechfiap_group130.techchallenge_fastfood.core.entities.OrderStatusEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderDto(
        Long id,
        LocalDateTime orderDate,
        OrderStatusEnum orderStatus,
        List<OrderItemDto> listOrderItemDto,
        BigDecimal total) {

    public OrderDto(Long id, LocalDateTime orderDate, OrderStatusEnum orderStatus, BigDecimal total) {
        this(id, orderDate, orderStatus, List.of(), total); // usa lista vazia por padrão
    }  
}
