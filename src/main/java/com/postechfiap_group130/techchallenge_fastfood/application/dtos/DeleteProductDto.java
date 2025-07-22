package com.postechfiap_group130.techchallenge_fastfood.application.dtos;

import java.math.BigDecimal;

import com.postechfiap_group130.techchallenge_fastfood.core.entities.Product;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.CategoryEnum.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class DeleteProductDto {
    public Long id;

    public static DeleteProductDto fromDomain(Product produto) {
        return new DeleteProductDto(
            produto.getId()
        );
    }
    
    public Product toDomain() {
        return new Product(id,"","",BigDecimal.valueOf(0), 
                           Category.ACOMPANHAMENTO, false);
    }
}
