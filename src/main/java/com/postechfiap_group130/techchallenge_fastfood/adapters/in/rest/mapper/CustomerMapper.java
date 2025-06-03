package com.postechfiap_group130.techchallenge_fastfood.adapters.in.rest.mapper;

import com.postechfiap_group130.techchallenge_fastfood.adapters.in.rest.dto.request.CustomerRequestDto;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toDomain(CustomerRequestDto customerRequestDto) {
        return new Customer(customerRequestDto.getName(), customerRequestDto.getEmail(),
                customerRequestDto.getPassword(), customerRequestDto.getCpf());
    }
}
