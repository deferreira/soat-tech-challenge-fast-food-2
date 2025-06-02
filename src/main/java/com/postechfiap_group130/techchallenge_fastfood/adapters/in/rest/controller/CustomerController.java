package com.postechfiap_group130.techchallenge_fastfood.adapters.in.rest.controller;

import com.postechfiap_group130.techchallenge_fastfood.adapters.in.rest.dto.request.CustomerRequestDto;
import com.postechfiap_group130.techchallenge_fastfood.adapters.in.rest.dto.response.ErrorResponseDto;
import com.postechfiap_group130.techchallenge_fastfood.adapters.in.rest.mapper.CustomerMapper;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.Customer;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.in.RegisterCustomerUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final RegisterCustomerUseCase registerCustomerUseCase;
    private final CustomerMapper customerMapper;

    public CustomerController(RegisterCustomerUseCase registerCustomerUseCase, CustomerMapper customerMapper) {
        this.registerCustomerUseCase = registerCustomerUseCase;
        this.customerMapper = customerMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<ErrorResponseDto> create(@RequestBody @Valid CustomerRequestDto customerRequestDto) {

        //Adicionar validacao se necessario
        Customer customer = customerMapper.toDomain(customerRequestDto);
        boolean result = registerCustomerUseCase.execute(customer);

        if (!result) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponseDto(400, "Customer já existe"));
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
