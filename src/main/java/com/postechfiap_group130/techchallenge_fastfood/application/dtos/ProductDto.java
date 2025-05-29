package com.postechfiap_group130.techchallenge_fastfood.application.dtos;

import java.math.BigDecimal;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.Product;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.Product.Category;

public class ProductDto {
    public Long id;
    public String name;
    public String description;
    public BigDecimal price;
    public Category category;
    public boolean avaliable;

    public ProductDto(Long id, String name, String description, BigDecimal price, Category category,
            boolean avaliable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.avaliable = avaliable;
    }

    public static ProductDto fromDomain(Product produto) {
        return new ProductDto(
            produto.getId(),
            produto.getName(),
            produto.getDescription(),
            produto.getPrice(),
            produto.getCategory(),
            produto.isAvaliable()
        );
    }
    
    public Product toDomain() {
        return new Product(id, name, description, price, category, avaliable);
    }
}
