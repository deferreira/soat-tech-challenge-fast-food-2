package com.postechfiap_group130.techchallenge_fastfood.domain.model;

import java.math.BigDecimal;

public class Product {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Category category;
    private boolean avaliable;

    public Product(Long id, String name, String description, BigDecimal price, Category category, boolean avaliable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.avaliable = avaliable;
    }

    
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public BigDecimal getPrice() {return price;}
    public void setPrice(BigDecimal price) {this.price = price;}
    public Category getCategory() {return category;}
    public void setCategory(Category category) {this.category = category;}
    public boolean isAvaliable() {return avaliable;}
    public void setAvaliable(boolean avaliable) {this.avaliable = avaliable;}

    public enum Category {
        LANCHE,
        BEBIDA,
        ACOMPANHAMENTO,
        SOBREMESA;
    }
}
