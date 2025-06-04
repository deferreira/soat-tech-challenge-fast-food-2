package com.postechfiap_group130.techchallenge_fastfood.domain.validators;

import com.postechfiap_group130.techchallenge_fastfood.application.dtos.ProductDto;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.CategoryEnum;

import br.com.fluentvalidator.AbstractValidator;
import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import static br.com.fluentvalidator.predicate.StringPredicate.stringSizeGreaterThan;

import java.util.Arrays;

public class ValidatorProduct extends AbstractValidator<ProductDto> {

    @Override
    public void rules() {
        
        setPropertyOnContext(ProductDto.class.getName());

        ruleFor(ProductDto::getName)
                .must(not(stringEmptyOrNull()))
                .withFieldName("name")
                .withMessage("Product name cannot be null or empty")
                .critical();
        ruleFor(ProductDto::getName)
                .must(not(stringSizeGreaterThan(100)))
                .withFieldName("name")
                .withMessage("Product name is too long. Max length is 100")
                .critical();
        ruleFor(ProductDto::getDescription)
                .must(not(stringEmptyOrNull()))
                .withFieldName("description")
                .withMessage("Description cannot be null or empty")
                .critical();
        ruleFor(ProductDto::getPrice)
                .must(not(nullValue()))
                    .withMessage("Price age must be not null")
                    .withFieldName("price")
                .critical();
        ruleFor(ProductDto::getCategory)
                .must(status -> Arrays.asList(CategoryEnum.Category.values()).contains(status))
                .withMessage("Invalid Category value");
    }
}
