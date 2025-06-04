package com.postechfiap_group130.techchallenge_fastfood.domain.ports.in;
import java.util.List;
import java.util.Optional;

import com.postechfiap_group130.techchallenge_fastfood.domain.model.CategoryEnum.Category;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.Product;

public interface ProductUseCasePort {
    Product addProduct(Product product);
    Product updateProduct(Product product);
    Optional<Product> findById(Long id);
    void deleteProduct(Product product);
    List<Product> FindByCategory(Category category);
}
