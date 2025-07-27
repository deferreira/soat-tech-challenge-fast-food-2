package com.postechfiap_group130.techchallenge_fastfood.api.data;

import com.postechfiap_group130.techchallenge_fastfood.api.data.jpa.CustomerEntity;
import com.postechfiap_group130.techchallenge_fastfood.api.data.jpa.CustomerJpaRepository;
import com.postechfiap_group130.techchallenge_fastfood.api.data.jpa.OrderEntity;
import com.postechfiap_group130.techchallenge_fastfood.api.data.jpa.OrderJpaRepository;
import com.postechfiap_group130.techchallenge_fastfood.core.dtos.CustomerDto;
import com.postechfiap_group130.techchallenge_fastfood.core.dtos.OrderDto;
import com.postechfiap_group130.techchallenge_fastfood.core.dtos.OrderItemDto;
import com.postechfiap_group130.techchallenge_fastfood.core.interfaces.DataSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class DataRepository implements DataSource {

    private final CustomerJpaRepository customerJpaRepository;
    private final OrderJpaRepository orderJpaRepository;
    private final PasswordEncoder passwordEncoder;

    public DataRepository(
            CustomerJpaRepository customerJpaRepository,
            OrderJpaRepository orderJpaRepository,
            PasswordEncoder passwordEncoder) {
        this.customerJpaRepository = customerJpaRepository;
        this.orderJpaRepository = orderJpaRepository;
        this.passwordEncoder = passwordEncoder;
    }
    //Recebe um DTO e transforma para Entity do JPA para salvar
    //Devolve um DTO
    @Override
    public void saveCustomer(CustomerDto customerDto) {
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
    public boolean existsCustomerByEmailOrCpf(String email, String cpf) {

        return customerJpaRepository.existsByEmailOrCpf(email, cpf);
    }

    @Override
    public CustomerDto findCustomerByCpf(String cpf) {
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
                                    orderItem.getId(),
                                    orderItem.getProductId(),
                                    orderItem.getQuantity(),
                                    orderItem.getPrice())))
                .toList();

        List<OrderDto> listOrderDto = listOrderEntity.stream()
                .map(item -> new OrderDto(
                        item.getId(),
                        item.getOrderDate(),
                        item.getOrderStatus(),
                        listOrderItemDto,
                        item.getTotal()))
                .toList();

        return listOrderDto;
    }

    @Override
    public OrderDto saveOrder(OrderDto orderDto) {
        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setOrderDate(orderDto.orderDate());
        orderEntity.setOrderStatus(orderDto.orderStatus());
        orderEntity.setTotal(orderDto.total());

        orderJpaRepository.save(orderEntity);
        return null;
    }


}
