package com.postechfiap_group130.techchallenge_fastfood.core.controllers;

import java.util.List;

import com.postechfiap_group130.techchallenge_fastfood.api.rest.dto.request.ProductRequestDto;
import com.postechfiap_group130.techchallenge_fastfood.api.rest.dto.response.ProductResponseDto;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.CategoryEnum.Category;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.Product;

import com.postechfiap_group130.techchallenge_fastfood.core.gateways.ProductGateway;
import com.postechfiap_group130.techchallenge_fastfood.core.interfaces.DataSource;
import com.postechfiap_group130.techchallenge_fastfood.core.presenters.ProductPresenter;
import com.postechfiap_group130.techchallenge_fastfood.core.usecases.GetProductsByCategoryUseCase;
import com.postechfiap_group130.techchallenge_fastfood.core.usecases.RegisterProductUseCase;

public class ProductController {

    private final DataSource dataSource;

    public ProductController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        ProductGateway productGateway = new ProductGateway(dataSource);
        RegisterProductUseCase registerProductUseCase = new RegisterProductUseCase(productGateway);

        Product product = registerProductUseCase.execute(productRequestDto);
        return ProductPresenter.toDto(product);
    }

    public ProductResponseDto updateProduct(ProductRequestDto productRequestDto) {
        ProductGateway productGateway = new ProductGateway(dataSource);
        RegisterProductUseCase registerProductUseCase = new RegisterProductUseCase(productGateway);

        Product product = registerProductUseCase.execute(productRequestDto);
        return ProductPresenter.toDto(product);
    }

     public List<ProductResponseDto> getProductsByCategory(Category category) {
        ProductGateway productGateway = new ProductGateway(dataSource);
        GetProductsByCategoryUseCase getProductsByCategoryUseCase = new GetProductsByCategoryUseCase(productGateway);

        List<Product> products = getProductsByCategoryUseCase.execute(category);
        return ProductPresenter.toDtoList(products);
    }
}
