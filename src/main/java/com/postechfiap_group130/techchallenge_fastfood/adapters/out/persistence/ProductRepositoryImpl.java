package com.postechfiap_group130.techchallenge_fastfood.adapters.out.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.postechfiap_group130.techchallenge_fastfood.domain.model.CategoryEnum.Category;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.Product;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.out.ProductRepositoryPort;

@Repository
public class ProductRepositoryImpl implements ProductRepositoryPort {
    private final ProductJpaRepository productJpaRepository;

    public ProductRepositoryImpl(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }

    @Override
    public Product Add(Product product) {
        ProductEntity productEntity = ProductEntity.fromEntity(product);
        productEntity.setId(product.getId());
        productJpaRepository.saveAndFlush(productEntity);
        return productEntity.toDomain();
    }

    @Override
    public Product Update(Product product) {
        ProductEntity productEntity = ProductEntity.fromEntity(product);
        productJpaRepository.saveAndFlush(productEntity);
        return productEntity.toDomain();
    }

    @Override
    public Optional<Product> FindById(Long id) {
        var productEntity = productJpaRepository.findById(id);
        var product = productEntity.get().toDomain();
        return Optional.ofNullable(product);
    }

    @Override
    public List<Product> FindAll() {
        List<Product> products = new ArrayList<>();
        var productEntity = productJpaRepository.findAll();
        productEntity.forEach(element -> {
            products.add(element.toDomain());
        });
        return products;
    }

    @Override
    public List<Product> FindByCategory(Category category) {
        List<Product> products = new ArrayList<>();
        var productEntity = productJpaRepository.findByCategory(category);
        productEntity.forEach(element -> {
            products.add(element.toDomain());
        });
        return products;
    }

    @Override
    public void Delete(Product product) {
        var productEntity = ProductEntity.fromEntity(product);
        productJpaRepository.delete(productEntity);
    }
}
