package com.postechfiap_group130.techchallenge_fastfood.domain.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter 
public class OrderItem {

    private Long orderId;
    private Long productId;
    private BigDecimal quantidade;
    private BigDecimal price;
    
    public BigDecimal totalAmount(){
        return price.multiply(quantidade);
    }
}
