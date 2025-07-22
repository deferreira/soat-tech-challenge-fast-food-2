package com.postechfiap_group130.techchallenge_fastfood.domain.ports.in;

import com.postechfiap_group130.techchallenge_fastfood.core.entities.Order;

public interface FakeCheckoutUseCase {
    Order execute(Order order);
}
