package com.postechfiap_group130.techchallenge_fastfood.core.entities;

public enum OrderStatusEnum {

    PENDING,
    RECEBIDO,
    EM_PREPARACAO,
    PRONTO,
    FINALIZADO;

    private OrderStatusEnum status;

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }
}

