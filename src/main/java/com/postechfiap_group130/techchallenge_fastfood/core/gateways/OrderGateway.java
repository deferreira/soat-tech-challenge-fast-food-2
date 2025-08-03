package com.postechfiap_group130.techchallenge_fastfood.core.gateways;

import com.postechfiap_group130.techchallenge_fastfood.core.dtos.OrderDto;
import com.postechfiap_group130.techchallenge_fastfood.core.dtos.OrderItemDto;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.Order;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.OrderItem;
import com.postechfiap_group130.techchallenge_fastfood.core.interfaces.DataSource;
import com.postechfiap_group130.techchallenge_fastfood.core.interfaces.IOrderGateway;

import java.util.List;
import java.util.Optional;

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
                        item.total(),
                        item.paymentId()
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
                order.getTotal(),
                order.getPaymentId());

        OrderDto saveOrder = dataSource.saveOrder(orderDto);
        order.setId(saveOrder.id());

        return order;
    }

    @Override
    public Optional<Order> findById(Long orderId) {
        List<OrderDto> allOrders = dataSource.getAllOrders();

        return allOrders.stream()
                .filter(orderDto -> orderId.equals(orderDto.id()))
                .findFirst()
                .map(this::mapToOrder);
    }

    private Order mapToOrder(OrderDto orderDto) {
        List<OrderItem> orderItems = orderDto.listOrderItemDto().stream()
                .map(itemDto -> new OrderItem(
                        itemDto.orderId(),
                        itemDto.productId(),
                        itemDto.quantity(),
                        itemDto.price()))
                .toList();

        Order order = new Order(orderItems);
        order.setId(orderDto.id());
        order.setPaymentId(orderDto.paymentId());
        return order;
    }
}
