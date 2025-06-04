
package com.postechfiap_group130.techchallenge_fastfood.domain.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Order {
    private Long id;
    private LocalDateTime orderDate;
    private OrderStatusEnum orderStatus;
    private List<OrderItem> items;

}