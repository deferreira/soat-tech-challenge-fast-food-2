package com.postechfiap_group130.techchallenge_fastfood.domain.model;

import java.math.BigDecimal;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.CategoryEnum.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter 
public class Product {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Category category;
    private boolean avaliable;
}
