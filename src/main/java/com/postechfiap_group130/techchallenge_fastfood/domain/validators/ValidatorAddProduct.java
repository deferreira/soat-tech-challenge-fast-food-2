package com.postechfiap_group130.techchallenge_fastfood.domain.validators;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;
import com.postechfiap_group130.techchallenge_fastfood.application.dtos.AddProductDto;
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
    }
}
