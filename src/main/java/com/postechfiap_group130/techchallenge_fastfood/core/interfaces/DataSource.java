package com.postechfiap_group130.techchallenge_fastfood.core.interfaces;

import java.util.List;


import com.postechfiap_group130.techchallenge_fastfood.core.dtos.CustomerDto;
import com.postechfiap_group130.techchallenge_fastfood.core.dtos.OrderDto;
import com.postechfiap_group130.techchallenge_fastfood.core.dtos.ProductCategoryDto;
import com.postechfiap_group130.techchallenge_fastfood.core.dtos.ProductDto;

public interface DataSource {
    void save(CustomerDto customerDto);
    boolean existsByEmailOrCpf(String email, String cpf);
    CustomerDto findByCpf(String cpf);
    List<OrderDto> getAllOrders();

    //Products
    ProductDto saveProduct(ProductDto productDto);
    void updateProduct(ProductDto productDto);
    ProductDto findById(Long id);
    List<ProductDto> findAll();
    List<ProductDto> findByCategory(ProductCategoryDto ProductCategoryDto);
}
