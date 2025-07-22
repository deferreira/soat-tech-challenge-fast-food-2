
package com.postechfiap_group130.techchallenge_fastfood.core.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Order {
    private Long id;
    private LocalDateTime orderDate;
    private OrderStatusEnum orderStatus;
    private List<OrderItem> items;
    private BigDecimal total;

    public Order(List<OrderItem> items) {
        this.items = items;
        this.orderStatus = OrderStatusEnum.PENDING;
        this.total = calculateTotal();
    }

    // setter opcional para setar o id vindo do banco
    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal calculateTotal() {
        return items.stream()
                .map(OrderItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}