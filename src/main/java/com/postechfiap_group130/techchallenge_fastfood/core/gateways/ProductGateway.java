package com.postechfiap_group130.techchallenge_fastfood.core.gateways;

import java.util.List;

import com.postechfiap_group130.techchallenge_fastfood.core.entities.CategoryEnum.Category;
import com.postechfiap_group130.techchallenge_fastfood.core.dtos.ProductCategoryDto;
import com.postechfiap_group130.techchallenge_fastfood.core.dtos.ProductDto;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.Product;
import com.postechfiap_group130.techchallenge_fastfood.core.interfaces.DataSource;
import com.postechfiap_group130.techchallenge_fastfood.core.interfaces.IProductGateway;

public class ProductGateway implements IProductGateway{

    private final DataSource dataSource;
    
    public ProductGateway(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public Product saveProduct(Product product) {
        ProductDto productDto = new ProductDto(0L, product.getName(), product.getDescription(), product.getPrice(), product.getCategory(), product.getAvaliable());
        productDto = dataSource.saveProduct(productDto);
        return new Product(productDto.id(),productDto.name(),productDto.description(),productDto.price(),productDto.category(),productDto.avaliable());
    }

    @Override
    public void updateProduct(Product product) {
        ProductDto productDto = new ProductDto(0L, product.getName(), product.getDescription(), product.getPrice(), product.getCategory(), product.getAvaliable());
        dataSource.updateProduct(productDto);
    }

    @Override
    public Product findById(Long id) {
        ProductDto productDto = dataSource.findById(id);
        return new Product(productDto.id(), productDto.name(), productDto.description(), productDto.price(), productDto.category(), productDto.avaliable());
    }

    @Override
    public List<Product> findAll() {
        List<ProductDto> productDtos = dataSource.findAll();
        List<Product> products = productDtos.stream()
                        .map(productDto -> 
                            new Product(
                                productDto.id(),
                                productDto.name(),
                                productDto.description(),
                                productDto.price(),
                                productDto.category(),
                                productDto.avaliable()
                            )).toList();
        return products;
    }
    
    @Override
    public List<Product> findByCategory(Category category) {
        ProductCategoryDto productCategoryDto = new ProductCategoryDto(category);
        List<ProductDto> productDtos = dataSource.findByCategory(productCategoryDto);
        List<Product> products = productDtos.stream()
                        .map(productDto -> 
                            new Product(
                                productDto.id(),
                                productDto.name(),
                                productDto.description(),
                                productDto.price(),
                                productDto.category(),
                                productDto.avaliable()
                            )).toList();
        return products;
    }

    @Override
    public Boolean existsByName(String name) {
        return dataSource.existsByName(name);
    }
}
