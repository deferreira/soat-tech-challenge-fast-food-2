package com.postechfiap_group130.techchallenge_fastfood.core.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.postechfiap_group130.techchallenge_fastfood.api.rest.dto.request.ProductRequestDto;
import com.postechfiap_group130.techchallenge_fastfood.api.rest.dto.request.UpdateProductRequestDto;
import com.postechfiap_group130.techchallenge_fastfood.api.rest.dto.response.ProductResponseDto;
import com.postechfiap_group130.techchallenge_fastfood.core.domainExceptions.DuplicateProductException;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.CategoryEnum.Category;
import com.postechfiap_group130.techchallenge_fastfood.core.interfaces.DataSource;

class ProductControllerTest {
    
    private ProductRequestDto mockProductRequestDto;

    DataSource dataSource = Mockito.mock(DataSource.class);
    ProductController productController = new ProductController(dataSource);

    @BeforeEach
    void setUp() {
        mockProductRequestDto = new ProductRequestDto("Coca cola 500ml", 
                "Refrigerante coca-cola 500ml", 
                new BigDecimal(8.90), 
                Category.BEBIDA);
    }

    @Test
    void createProductSuccess() throws Exception {
        // Arrange
        ProductRequestDto productRequestDto = new ProductRequestDto("Cheese Burguer", 
                "Cheese Burguer", 
                new BigDecimal(14.90), 
                Category.LANCHE);

        // Act
        ProductResponseDto result = productController.createProduct(productRequestDto);

        // Assert
        assertNotNull(result);
        verify(dataSource).existsByName(anyString());
        verify(dataSource).saveProduct(any());

    }

    @Test
    void createProduct_fail_when_product_exists() {
        // Arrange
        ProductRequestDto productRequestDto = new ProductRequestDto("Cheese Burguer", 
                "Cheese Burguer", 
                new BigDecimal(14.90), 
                Category.LANCHE);

        when(dataSource.existsByName(anyString())).thenReturn(Boolean.TRUE);

        // Act
        var ex = assertThrows(DuplicateProductException.class, () -> productController.createProduct(productRequestDto));

        // Assert
        assertEquals("Product name already registered in the database!", ex.getMessage());
        verify(dataSource).existsByName(anyString());

    }

    @Test
    void updateProductSuccess() throws Exception {
        // Arrange
        UpdateProductRequestDto updateProductRequestDto = 
            new UpdateProductRequestDto(1L, "Cheese Burguer", 
                "Cheese Burguer", 
                new BigDecimal(12.45), 
                Category.LANCHE, true);

        // Act
        ProductResponseDto result = productController.updateProduct(updateProductRequestDto);

        // Assert
        assertNotNull(result);
        verify(dataSource).existsByName(anyString());
        verify(dataSource).saveProduct(any());

    }
}
