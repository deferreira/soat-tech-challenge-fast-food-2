package com.postechfiap_group130.techchallenge_fastfood.adapters.in.controllers;

import br.com.fluentvalidator.Validator;
import br.com.fluentvalidator.context.ValidationResult;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.postechfiap_group130.techchallenge_fastfood.application.dtos.AddProductDto;
import com.postechfiap_group130.techchallenge_fastfood.application.dtos.ProductDto;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.Product;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.in.ProductUseCase;
import com.postechfiap_group130.techchallenge_fastfood.domain.validators.ValidatorAddProduct;

@RestController
@RequestMapping("/api/produtos")
//@Tag(name = "Produtos", description = "API para gerenciamento de produtos") - Aguardar Dependencia Swagger
public class ProductController {
    private final ProductUseCase productUseCase;

    public ProductController(ProductUseCase productUseCase) {
        this.productUseCase = productUseCase;
    }

    @PostMapping
    public ResponseEntity<?> criarProduto(@RequestBody AddProductDto produtoDto) {
        final Validator<AddProductDto> validatorProduct = new ValidatorAddProduct();
        final ValidationResult result = validatorProduct.validate(produtoDto);
        if (!result.isValid()){
             StringBuilder messageString = new StringBuilder();
            result.getErrors().forEach(elemento -> { messageString.append(elemento.getMessage());});
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageString.toString());
        }
        else {
            Product produto = productUseCase.addProduct(produtoDto.toDomain());
            return ResponseEntity.status(HttpStatus.CREATED).body(ProductDto.fromDomain(produto));
        }
    }
}
