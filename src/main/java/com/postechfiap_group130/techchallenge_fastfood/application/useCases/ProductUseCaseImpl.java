package com.postechfiap_group130.techchallenge_fastfood.application.useCases;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.postechfiap_group130.techchallenge_fastfood.domain.model.Product;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.Product.Category;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.out.ProductRepositoryPort;

@Service
public class ProductUseCaseImpl {

    private final ProductRepositoryPort productRepository;

    public ProductUseCaseImpl(ProductRepositoryPort productRepository) {
        this.productRepository = productRepository;
    }

    public Product Add(Product product){
        return productRepository.Add(product);
    }

    public Optional<Product> FindById(Long id){
        return productRepository.FindById(id);
    }

    public List<Product> FindAll(){
        return productRepository.FindAll();
    }

    public List<Product> FindByCategory(Category category){
        return productRepository.FindByCategory(category);
    }
}
