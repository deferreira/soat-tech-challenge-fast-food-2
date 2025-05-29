package com.postechfiap_group130.techchallenge_fastfood.application.dtos;

import java.math.BigDecimal;

import com.postechfiap_group130.techchallenge_fastfood.domain.model.Product;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.Product.Category;

public class AddProductDto {
    public String name;
    public String description;
    public BigDecimal price;
    public Category category; 

     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
        return new Product(null, name, description, price, category, true);
    }
}
