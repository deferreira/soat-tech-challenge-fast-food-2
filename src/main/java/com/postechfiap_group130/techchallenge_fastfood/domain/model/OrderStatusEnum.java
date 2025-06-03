package com.postechfiap_group130.techchallenge_fastfood.domain.model;

public class OrderStatusEnum {
    
    public enum OrderStatus {
        
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
}

