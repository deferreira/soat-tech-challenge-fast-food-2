package com.postechfiap_group130.techchallenge_fastfood.application.dtos;

import com.postechfiap_group130.techchallenge_fastfood.core.dtos.OrderItemDto;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.Order;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class OrderRequestDto {
    private List<OrderItemDto> items;


    public Order toDomain() {
        List<OrderItem> listOrderItem = items.stream().map((orderItemDto) -> new OrderItem(
                        orderItemDto.orderId(),
                        orderItemDto.productId(),
                        orderItemDto.quantity(),
                        orderItemDto.price()))
                .toList();

        return new Order(null, null, null, listOrderItem, null, null);
    }
}
