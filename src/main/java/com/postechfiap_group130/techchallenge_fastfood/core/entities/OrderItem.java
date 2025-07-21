package com.postechfiap_group130.techchallenge_fastfood.core.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItem {

    private Long orderId;
    private Long productId;
    private BigInteger quantity;

}