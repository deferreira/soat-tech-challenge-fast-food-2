package com.postechfiap_group130.techchallenge_fastfood.core.entities;

import java.math.BigDecimal;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.CategoryEnum.Category;
import lombok.Getter;

@Getter
public class Product {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Category category;
    private Boolean avaliable;

    public Product(Long id, String name, String description, BigDecimal price, Category category, Boolean avaliable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.avaliable = avaliable;
    }
    public Product(String name, String description, BigDecimal price, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.avaliable = true;
    }
}
