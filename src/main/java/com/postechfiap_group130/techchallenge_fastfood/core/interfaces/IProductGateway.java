package com.postechfiap_group130.techchallenge_fastfood.core.interfaces;

import java.util.List;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.CategoryEnum.Category;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.Product;

public interface IProductsGateway {
    void AddProduct(Product product);
    void UpdateProduct(Product product);
    Product FindById(Long id);
    List<Product> FindAll();
    List<Product> FindByCategory(Category category);
    void Delete(Product product);
}
