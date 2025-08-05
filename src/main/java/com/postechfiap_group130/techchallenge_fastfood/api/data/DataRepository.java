package com.postechfiap_group130.techchallenge_fastfood.api.data;

import com.postechfiap_group130.techchallenge_fastfood.api.data.jpa.CustomerEntity;
import com.postechfiap_group130.techchallenge_fastfood.api.data.jpa.CustomerJpaRepository;
import com.postechfiap_group130.techchallenge_fastfood.api.data.jpa.OrderEntity;
import com.postechfiap_group130.techchallenge_fastfood.api.data.jpa.OrderJpaRepository;
import com.postechfiap_group130.techchallenge_fastfood.api.data.jpa.ProductEntity;
import com.postechfiap_group130.techchallenge_fastfood.api.data.jpa.ProductJpaRepository;
import com.postechfiap_group130.techchallenge_fastfood.core.dtos.CustomerDto;
import com.postechfiap_group130.techchallenge_fastfood.core.dtos.OrderDto;
import com.postechfiap_group130.techchallenge_fastfood.core.dtos.OrderItemDto;
import com.postechfiap_group130.techchallenge_fastfood.core.dtos.ProductCategoryDto;
import com.postechfiap_group130.techchallenge_fastfood.core.dtos.ProductDto;
import com.postechfiap_group130.techchallenge_fastfood.core.interfaces.DataSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class DataRepository implements DataSource {

    private final CustomerJpaRepository customerJpaRepository;
    private final OrderJpaRepository orderJpaRepository;
    private final ProductJpaRepository productJpaRepository;
    private final PasswordEncoder passwordEncoder;

    public DataRepository(
            CustomerJpaRepository customerJpaRepository,
            OrderJpaRepository orderJpaRepository,
            ProductJpaRepository productJpaRepository,
            PasswordEncoder passwordEncoder) {
        this.customerJpaRepository = customerJpaRepository;
        this.orderJpaRepository = orderJpaRepository;
        this.productJpaRepository = productJpaRepository;
        this.passwordEncoder = passwordEncoder;
    }
    //Recebe um DTO e transforma para Entity do JPA para salvar
    //Devolve um DTO
    @Override
    public void save(CustomerDto customerDto) {
        String encryptedPassword = passwordEncoder.encode(customerDto.password());

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customerDto.id());
        customerEntity.setName(customerDto.name());
        customerEntity.setEmail(customerDto.email());
        customerEntity.setPassword(encryptedPassword);
        customerEntity.setCpf(customerDto.cpf());

        customerJpaRepository.save(customerEntity);

    }

    @Override
    public boolean existsByEmailOrCpf(String email, String cpf) {

        return customerJpaRepository.existsByEmailOrCpf(email, cpf);
    }

    @Override
    public CustomerDto findByCpf(String cpf) {
        CustomerEntity entity = customerJpaRepository.findByCpf(cpf);
        if (entity == null) return null;

        CustomerDto customerDto = new CustomerDto(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getCpf(),
                entity.getPassword());

        return customerDto;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<OrderEntity> listOrderEntity = orderJpaRepository.findAll();
        if (listOrderEntity == null) return null;

        List<OrderItemDto> listOrderItemDto = listOrderEntity.stream()
                    .flatMap((orderEntity) ->  orderEntity.getItems().stream()
                            .map((orderItem) -> new OrderItemDto(
                                    orderItem.getId(), orderItem.getProductId(),
                                    orderItem.getQuantity())))
                .toList();

        List<OrderDto> listOrderDto = listOrderEntity.stream()
                .map(item -> new OrderDto(
                        item.getId(),
                        item.getOrderDate(),
                        item.getOrderStatus(),
                        listOrderItemDto))
                .toList();

        return listOrderDto;
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(productDto.id());
        productEntity.setName(productDto.name());
        productEntity.setDescription(productDto.description());
        productEntity.setPrice(productDto.price());
        productEntity.setCategory(productDto.category());
        productEntity.setAvaliable(productDto.avaliable());

        productEntity = productJpaRepository.save(productEntity);

        return new ProductDto(
                    productEntity.getId(), 
                    productEntity.getName(), 
                    productEntity.getDescription(),
                    productEntity.getPrice(), 
                    productEntity.getCategory(),
                    productEntity.getAvaliable()
                );
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        this.saveProduct(productDto);
        return productDto;
    }

    @Override
    public ProductDto findById(Long id) {
        java.util.Optional<ProductEntity> entity = productJpaRepository.findById(id);

        if (entity.isEmpty()) return null;

        ProductDto productDto = new ProductDto(
                entity.get().getId(),
                entity.get().getName(),
                entity.get().getDescription(),
                entity.get().getPrice(),
                entity.get().getCategory(),
                entity.get().getAvaliable());

        return productDto;
    }

    @Override
    public List<ProductDto> findAll() {

        List<ProductEntity> products = productJpaRepository.findAll();
        List<ProductDto> productsDto = products.stream()
                .map(item -> new ProductDto(
                        item.getId(),
                        item.getName(),
                        item.getDescription(),
                        item.getPrice(),
                        item.getCategory(),
                        item.getAvaliable()
                        ))
                .toList();
        return productsDto;
    }

    @Override
    public List<ProductDto> findByCategory(ProductCategoryDto ProductCategoryDto) {
        List<ProductEntity> products = productJpaRepository.findByCategory(ProductCategoryDto.category());
        List<ProductDto> productsDto = products.stream()
                .map(item -> new ProductDto(
                        item.getId(),
                        item.getName(),
                        item.getDescription(),
                        item.getPrice(),
                        item.getCategory(),
                        item.getAvaliable()
                        ))
                .toList();
        return productsDto;
    }
    @Override
    public Boolean existsByName(String name) {
        return productJpaRepository.existsByName(name);
    }
}
