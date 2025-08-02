package com.postechfiap_group130.techchallenge_fastfood.core.gateways;

import com.postechfiap_group130.techchallenge_fastfood.core.dtos.OrderDto;
import com.postechfiap_group130.techchallenge_fastfood.core.dtos.OrderItemDto;
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
                                orderItemDto.quantity(),
                                orderItemDto.price()))))
                .toList();

        List<Order> listOrders = result.stream()
                .map((item) -> new Order(
                        item.id(),
                        item.orderDate(),
                        item.orderStatus(),
                        listOrderItems,
                        item.total()
                )).toList();

        return listOrders;
    }

    @Override
    public Order save(Order order) {
        List<OrderItemDto> orderItemDtoList = order.getItems().stream().map(item -> new OrderItemDto(
                        item.getId(),
                        item.getProductId(),
                        item.getQuantity(),
                        item.getPrice()))
                .toList();

        OrderDto orderDto = new OrderDto(
                null,
                order.getOrderDate(),
                order.getOrderStatus(),
                orderItemDtoList,
                order.getTotal());

        OrderDto saveOrder = dataSource.saveOrder(orderDto);
        order.setId(saveOrder.id());

        return order;
    }

    @Override
    public Order getOrderById(Long id) {
        OrderDto order = dataSource.getOrderById(id);

        if (order == null) return null;

        List<OrderItem> orderItemList = order.listOrderItemDto().stream()
                .map(item -> new OrderItem(
                        item.orderId(),
                        item.productId(),
                        item.quantity(),
                        item.price()))
                .toList();

        return new Order(order.id(), order.orderDate(), order.orderStatus(), orderItemList, order.total());
    }

}
