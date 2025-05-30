package com.postechfiap_group130.techchallenge_fastfood.application.dtos;

import java.math.BigDecimal;

import com.postechfiap_group130.techchallenge_fastfood.domain.model.CategoryEnum.Category;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AddProductDto {

    public String name;
    public String description;
    public BigDecimal price;
    public Category category; 

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
