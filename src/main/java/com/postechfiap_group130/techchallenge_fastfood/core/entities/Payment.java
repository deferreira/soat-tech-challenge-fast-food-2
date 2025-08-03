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

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(PaymentStatusEnum status) {
        this.status = status;
    }

    public boolean isApproved() {
        return PaymentStatusEnum.APPROVED.equals(this.status);
    }

    public boolean isRejected() {
        return PaymentStatusEnum.REJECTED.equals(this.status);
    }

    public boolean isPending() {
        return PaymentStatusEnum.PENDING.equals(this.status);
    }
}