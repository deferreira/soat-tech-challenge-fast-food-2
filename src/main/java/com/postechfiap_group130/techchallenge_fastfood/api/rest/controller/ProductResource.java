package com.postechfiap_group130.techchallenge_fastfood.api.rest.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.postechfiap_group130.techchallenge_fastfood.core.controllers.ProductController;
import com.postechfiap_group130.techchallenge_fastfood.api.data.DataRepository;
import com.postechfiap_group130.techchallenge_fastfood.api.rest.dto.request.ProductRequestDto;
import com.postechfiap_group130.techchallenge_fastfood.api.rest.dto.response.ProductResponseDto;

@RestController
@RequestMapping("/products")
public class ProductResource {
    
    private final DataRepository dataRepository;
    
    public ProductResource(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
        
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<?> GetProductByCategory(@PathVariable("category") Category category){
        
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductRequestDto produtoDto) {
        ProductController productController = new ProductController(dataRepository);
        ProductResponseDto productResponseDto = productController.createProduct(produtoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponseDto);
    
    }
    
    @PutMapping
    public ResponseEntity<?> updateProduct(@RequestBody ProductRequestDto produtoDto) {
        ProductController productController = new ProductController(dataRepository);
        productController.updateProduct(produtoDto);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
   
}
