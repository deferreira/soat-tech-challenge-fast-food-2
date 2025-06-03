package com.postechfiap_group130.techchallenge_fastfood.adapters.in.rest.controller;

import com.postechfiap_group130.techchallenge_fastfood.adapters.in.rest.dto.request.CustomerRequestDto;
import com.postechfiap_group130.techchallenge_fastfood.adapters.in.rest.dto.response.CustomerResponseDto;
import com.postechfiap_group130.techchallenge_fastfood.adapters.in.rest.dto.response.ErrorResponseDto;
import com.postechfiap_group130.techchallenge_fastfood.adapters.in.rest.mapper.CustomerMapper;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.Customer;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.in.RegisterCustomerUseCase;
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
public class CustomerController {

    private final RegisterCustomerUseCase registerCustomerUseCase;
    private final FindCustomerByCpfUseCase findCustomerByCpfUseCase;
    private final CustomerMapper customerMapper;

    public CustomerController(RegisterCustomerUseCase registerCustomerUseCase, 
                            FindCustomerByCpfUseCase findCustomerByCpfUseCase,
                            CustomerMapper customerMapper) {
        this.registerCustomerUseCase = registerCustomerUseCase;
        this.findCustomerByCpfUseCase = findCustomerByCpfUseCase;
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


    @GetMapping("/{cpf}")
    public ResponseEntity<CustomerResponseDto> findByCpf(String cpf) {
        if (!CpfValidator.isValid(cpf)) {
            throw new InvalidCpfException("Invalid CPF: " + cpf);
        }
        
        Customer response = findCustomerByCpfUseCase.findByCpf(cpf);

        return response != null ? ResponseEntity.ok(customerMapper.toResponseDto(response)) : ResponseEntity.notFound().build();
    }

}
