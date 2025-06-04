package com.postechfiap_group130.techchallenge_fastfood.adapters.out.persistence;

import com.postechfiap_group130.techchallenge_fastfood.domain.model.Order;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.OrderItem;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.out.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    OrderJpaRepository orderJpaRepository;

    OrderRepositoryImpl(OrderJpaRepository orderJpaRepository) {
        this.orderJpaRepository = orderJpaRepository;
    }

    public Order save(Order order) {
    OrderEntity orderEntity = OrderEntity.fromEntity(order);

        OrderEntity result = orderJpaRepository.save(orderEntity);

        List<OrderItem> orderItemList = result.getItems().stream().map(orderItemEntity -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(result.getId());
            orderItem.setProductId(orderItemEntity.getProductId());
            orderItem.setQuantity(orderItemEntity.getQuantity());

            return orderItem;
        }).toList();

        return new Order(result.getId(), order.getOrderDate(), order.getOrderStatus(), orderItemList);
    };
}
