package com.postechfiap_group130.techchallenge_fastfood.application.dtos;

import com.postechfiap_group130.techchallenge_fastfood.core.entities.Order;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class OrderRequestDto {
    private List<OrderItem> items;


    public Order toDomain() {
        return new Order(null, null, null, items);
    }
}
