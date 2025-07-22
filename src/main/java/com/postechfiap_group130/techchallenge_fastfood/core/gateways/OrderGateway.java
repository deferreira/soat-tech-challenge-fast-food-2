package com.postechfiap_group130.techchallenge_fastfood.core.gateways;

import com.postechfiap_group130.techchallenge_fastfood.core.dtos.OrderDto;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.Order;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.OrderItem;
import com.postechfiap_group130.techchallenge_fastfood.core.interfaces.DataSource;
import com.postechfiap_group130.techchallenge_fastfood.core.interfaces.IOrderGateway;

import java.util.List;

public class OrderGateway implements IOrderGateway {

    private final DataSource dataSource;

    public OrderGateway(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Order> getAllOrders() {
        List<OrderDto> result = dataSource.getAllOrders();

        List<OrderItem> listOrderItems = result.stream()
                .flatMap((orderDto -> orderDto.listOrderItemDto().stream()
                        .map(orderItemDto -> new OrderItem(
                                orderItemDto.orderId(),
                                orderItemDto.productId(),
                                orderItemDto.quantity()))))
                .toList();

        List<Order> listOrders = result.stream()
                .map((item) -> new Order(
                        item.id(), item.orderDate(),
                        item.orderStatus(),
                        listOrderItems
                        )).toList();

        return listOrders;
    }


}
