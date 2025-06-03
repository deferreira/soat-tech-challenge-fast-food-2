package com.postechfiap_group130.techchallenge_fastfood.domain.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Cart {
    private List<CartItem> items; 

    public void AddItem(CartItem item){

    }
}
