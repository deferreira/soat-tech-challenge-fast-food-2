package com.postechfiap_group130.techchallenge_fastfood.api.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, Long> {
}
