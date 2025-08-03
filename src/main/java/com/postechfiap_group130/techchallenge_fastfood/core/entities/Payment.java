package com.postechfiap_group130.techchallenge_fastfood.core.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class Payment {
    private Long id;
    private Long orderId;
    private BigDecimal amount;
    private PaymentStatusEnum status;

    public Payment(Long orderId, BigDecimal amount) {
        this.orderId = orderId;
        this.amount = amount;
        this.status = PaymentStatusEnum.PENDING;
    }

    public Payment(Long id, PaymentStatusEnum status) {
        this.id = id;
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(PaymentStatusEnum status) {
        this.status = status;
    }
}