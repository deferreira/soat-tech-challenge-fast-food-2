package com.postechfiap_group130.techchallenge_fastfood.application.useCases;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.CategoryEnum.Category;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.Product;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.in.ProductUseCasePort;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.out.ProductRepositoryPort;

@Service
public class ProductUseCaseImpl implements ProductUseCasePort {

    private final ProductRepositoryPort productRepository;
    
    public ProductUseCaseImpl(ProductRepositoryPort productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> FindByCategory(Category category){
        return productRepository.FindByCategory(category);
    }

    @Override
    public Product addProduct(Product product) {
         return productRepository.Add(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.Update(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.FindById(id);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.Delete(product);
    }
}
