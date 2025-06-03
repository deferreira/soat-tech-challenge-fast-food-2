package com.postechfiap_group130.techchallenge_fastfood.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.OrderStatusEnum.OrderStatus;
import lombok.Getter;

@Getter

public class Order {
    private Long id;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private List<OrderItem> items;


    public Order(Cart cart){
        this.orderDate = LocalDateTime.now();
        this.orderStatus = OrderStatus.RECEBIDO;
        for (CartItem cartItem : cart.getItems()) {
            var orderItem = new OrderItem();
            orderItem.setPrice(cartItem.getProduct().getPrice());
            orderItem.setQuantidade(BigDecimal.valueOf(cartItem.getQuantidade()));
            orderItem.setProduct(cartItem.getProduct());
        }
    }
}
