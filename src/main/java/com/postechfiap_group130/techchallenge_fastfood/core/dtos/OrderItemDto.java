package com.postechfiap_group130.techchallenge_fastfood.core.dtos;

import java.math.BigInteger;

public record OrderItemDto(
        Long orderId,
        Long productId,
        BigInteger quantity) {
}
