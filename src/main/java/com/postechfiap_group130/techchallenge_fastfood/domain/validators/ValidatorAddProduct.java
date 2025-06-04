package com.postechfiap_group130.techchallenge_fastfood.domain.validators;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import static br.com.fluentvalidator.predicate.StringPredicate.stringSizeGreaterThan;

import java.util.Arrays;

import com.postechfiap_group130.techchallenge_fastfood.application.dtos.AddProductDto;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.CategoryEnum;

import br.com.fluentvalidator.AbstractValidator;

public class ValidatorAddProduct extends AbstractValidator<AddProductDto> {
    @Override
    public void rules() {
        
        setPropertyOnContext(AddProductDto.class.getName());

        ruleFor(AddProductDto::getName)
                .must(not(stringEmptyOrNull()))
                .withFieldName("name")
                .withMessage("Product name cannot be null or empty")
                .critical();
        ruleFor(AddProductDto::getName)
                .must(not(stringSizeGreaterThan(100)))
                .withFieldName("name")
                .withMessage("Product name is too long. Max length is 100")
                .critical();
        ruleFor(AddProductDto::getDescription)
                .must(not(stringEmptyOrNull()))
                .withFieldName("description")
                .withMessage("Description cannot be null or empty")
                .critical();
        ruleFor(AddProductDto::getPrice)
                .must(not(nullValue()))
                    .withMessage("Price age must be not null")
                    .withFieldName("price")
                .critical();
        ruleFor(AddProductDto::getCategory)
                .must(status -> Arrays.asList(CategoryEnum.Category.values()).contains(status))
                .withMessage("Invalid Category value");
    }
}
