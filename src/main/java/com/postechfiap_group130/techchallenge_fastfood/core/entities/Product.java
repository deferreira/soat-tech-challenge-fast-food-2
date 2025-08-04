package com.postechfiap_group130.techchallenge_fastfood.core.entities;

import java.math.BigDecimal;

import com.postechfiap_group130.techchallenge_fastfood.core.domainExceptions.InvalidPropertyProductException;
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

    public Product(Long id, String name, String description, BigDecimal price, Category category, Boolean avaliable){
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

    public void Validate() throws InvalidPropertyProductException{
        if (this.name == null || this.name.isEmpty()){
            throw new InvalidPropertyProductException("Product name cannot be null or empty");
        }

        if (this.name.length() > 100){
            throw new InvalidPropertyProductException("Product name is too long. Max length is 100");
        }

        if (this.description == null || this.description.isEmpty()){
            throw new InvalidPropertyProductException("Product description cannot be null or empty");
        }

        if (this.price == null){
            throw new InvalidPropertyProductException("Product price must be not null");
        }

        if (this.price.compareTo(BigDecimal.ZERO) <= 0){
            throw new InvalidPropertyProductException("Product price must be greater than 0");
        }
    }

        
}
