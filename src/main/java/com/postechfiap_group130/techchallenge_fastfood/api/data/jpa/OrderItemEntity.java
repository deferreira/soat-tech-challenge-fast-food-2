package com.postechfiap_group130.techchallenge_fastfood.api.data.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Table(name = "orderItems")
@Getter
@Setter
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private BigInteger quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;
}
