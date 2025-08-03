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

    public String getStatus() {
        return orderStatus != null ? orderStatus.name() : null;
    }

    public LocalDateTime getCreatedAt() {
        return orderDate;
    }
}
