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
import com.postechfiap_group130.techchallenge_fastfood.application.dtos.DeleteProductDto;
import com.postechfiap_group130.techchallenge_fastfood.application.dtos.ProductDto;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.Product;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.in.ProductUseCasePort;
import com.postechfiap_group130.techchallenge_fastfood.domain.validators.ValidatorAddProduct;
import com.postechfiap_group130.techchallenge_fastfood.domain.validators.ValidatorProduct;

@RestController
@RequestMapping("/api/produtos")
//@Tag(name = "Produtos", description = "API para gerenciamento de produtos") - Aguardar Dependencia Swagger
public class ProductController {
    private final ProductUseCasePort productUseCase;

    public ProductController(ProductUseCasePort productUseCase) {
        this.productUseCase = productUseCase;
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody AddProductDto produtoDto) {
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
    
    @PostMapping
    public ResponseEntity<?> updateProduct(@RequestBody ProductDto produtoDto) {
        final Validator<ProductDto> validatorProduct = new ValidatorProduct();
        final ValidationResult result = validatorProduct.validate(produtoDto);
        if (!result.isValid()){
            StringBuilder messageString = new StringBuilder();
            result.getErrors().forEach(elemento -> { messageString.append(elemento.getMessage());});
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageString.toString());
        }
        var product = productUseCase.findById(produtoDto.getId());
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        else {
            Product produto = productUseCase.updateProduct(produtoDto.toDomain());
            return ResponseEntity.status(HttpStatus.OK).body(ProductDto.fromDomain(produto));
        }
    }

    @PostMapping
    public ResponseEntity<?> deleteProduct(@RequestBody DeleteProductDto produtoDto) {
        var product = productUseCase.findById(produtoDto.getId());
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        else {
            productUseCase.deleteProduct(product.get());
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }
}
