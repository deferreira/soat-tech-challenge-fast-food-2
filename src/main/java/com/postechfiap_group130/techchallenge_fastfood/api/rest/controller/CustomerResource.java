package com.postechfiap_group130.techchallenge_fastfood.api.rest.controller;

import com.postechfiap_group130.techchallenge_fastfood.api.rest.dto.request.CustomerRequestDto;
import com.postechfiap_group130.techchallenge_fastfood.api.rest.dto.response.CustomerResponseDto;
import com.postechfiap_group130.techchallenge_fastfood.api.rest.mapper.CustomerMapper;
import com.postechfiap_group130.techchallenge_fastfood.api.data.DataRepository;
import com.postechfiap_group130.techchallenge_fastfood.core.controllers.CustomerController;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.Customer;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.in.FindCustomerByCpfUseCase;
import com.postechfiap_group130.techchallenge_fastfood.domain.validation.CpfValidator;
import com.postechfiap_group130.techchallenge_fastfood.domain.exception.InvalidCpfException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerResource {

    private final DataRepository dataRepository;

    private final FindCustomerByCpfUseCase findCustomerByCpfUseCase;
    private final CustomerMapper customerMapper;


    public CustomerResource(FindCustomerByCpfUseCase findCustomerByCpfUseCase,
                            CustomerMapper customerMapper,
                            DataRepository dataRepository) {
        this.findCustomerByCpfUseCase = findCustomerByCpfUseCase;
        this.customerMapper = customerMapper;
        this.dataRepository = dataRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<CustomerResponseDto> create(@RequestBody @Valid CustomerRequestDto customerRequestDto) {
        CustomerController customerController = new CustomerController(dataRepository);
        CustomerResponseDto result = customerController.createCustomer(customerRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }


    @GetMapping("/{cpf}")
    public ResponseEntity<CustomerResponseDto> findByCpf(String cpf) {
        if (!CpfValidator.isValid(cpf)) {
            throw new InvalidCpfException("Invalid CPF: " + cpf);
        }

        Customer response = findCustomerByCpfUseCase.findByCpf(cpf);

        return response != null ? ResponseEntity.ok(customerMapper.toResponseDto(response)) : ResponseEntity.notFound().build();
    }

}
