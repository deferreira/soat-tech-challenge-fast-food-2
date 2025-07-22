package com.postechfiap_group130.techchallenge_fastfood.domain.ports.out;

import java.util.List;
import java.util.Optional;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.CategoryEnum.Category;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.Product;


public interface ProductRepositoryPort {
    Product Add(Product product);
    Product Update(Product product);
    Optional<Product> FindById(Long id);
    List<Product> FindAll();
    List<Product> FindByCategory(Category category);
    void Delete(Product product);
}
