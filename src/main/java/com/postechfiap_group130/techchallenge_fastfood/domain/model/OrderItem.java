package com.postechfiap_group130.techchallenge_fastfood.domain.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter 
public class OrderItem {

    private Long orderId;
    private Product product;
    private BigDecimal quantidade;
    private BigDecimal price;
    
    public BigDecimal totalAmount(){
        return price.multiply(quantidade);
    }
}
