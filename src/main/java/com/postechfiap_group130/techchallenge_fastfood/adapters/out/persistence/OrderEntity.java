package com.postechfiap_group130.techchallenge_fastfood.adapters.out.persistence;

import com.postechfiap_group130.techchallenge_fastfood.domain.model.Order;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.OrderItem;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.OrderStatusEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatusEnum orderStatus;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItemEntity> items;


    public static OrderEntity fromEntity(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(order.getId());
        orderEntity.setOrderDate(order.getOrderDate());
        orderEntity.setOrderStatus(order.getOrderStatus());

        List<OrderItemEntity> itemEntities = order.getItems().stream().map(orderItem -> {
            OrderItemEntity orderItemEntity = new OrderItemEntity();
            orderItemEntity.setId(orderItem.getOrderId());
            orderItemEntity.setProductId(orderItem.getProductId());
            orderItemEntity.setQuantity(orderItem.getQuantity());
            orderItemEntity.setOrder(orderEntity);

            return orderItemEntity;
        }).toList();

        orderEntity.setItems(itemEntities);

        return orderEntity;
    }

    public static Order toDomain(OrderEntity orderEntity) {
        List<OrderItem> orderItems = orderEntity.getItems().stream()
            .map(item -> new OrderItem(item.getId(), item.getProductId(), item.getQuantity()))
            .toList();
        return new Order(orderEntity.getId(), orderEntity.getOrderDate(), orderEntity.getOrderStatus(), orderItems);
    }

}
