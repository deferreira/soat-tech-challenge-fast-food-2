package com.postechfiap_group130.techchallenge_fastfood.adapters.in.rest.controller;

import com.postechfiap_group130.techchallenge_fastfood.adapters.in.rest.dto.request.CustomerRequestDto;
import com.postechfiap_group130.techchallenge_fastfood.adapters.in.rest.dto.response.ErrorResponseDto;
import com.postechfiap_group130.techchallenge_fastfood.adapters.in.rest.mapper.CustomerMapper;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.in.RegisterCustomerUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class CustomerControllerTest {

    private final RegisterCustomerUseCase registerCustomerUseCase = mock(RegisterCustomerUseCase.class);
    private final CustomerMapper customerMapper = spy(CustomerMapper.class);
    private final CustomerController controller = new CustomerController(registerCustomerUseCase, customerMapper);

    @Test
    void create_success() {
    CustomerRequestDto customerRequestDto = new CustomerRequestDto("Jhon", "jhondoe@gmail.com",
            "12345678", "111.111.111-11");

    when(registerCustomerUseCase.execute(any())).thenReturn(Boolean.TRUE);

     ResponseEntity<ErrorResponseDto> result = controller.create(customerRequestDto);

        assertEquals(201, result.getStatusCode().value());
        verify(registerCustomerUseCase).execute(any());
    }

    @Test
    void create_when_email_or_cpf_exists() {
        CustomerRequestDto customerRequestDto = new CustomerRequestDto("Jhon", "jhondoe@gmail.com",
                "12345678", "111.111.111-11");

        when(registerCustomerUseCase.execute(any())).thenReturn(Boolean.FALSE);

        ResponseEntity<ErrorResponseDto> result = controller.create(customerRequestDto);

        assertEquals(400, result.getStatusCode().value());
        assertNotNull(result.getBody());
        assertEquals("Customer já existe", result.getBody().error());
        verify(registerCustomerUseCase).execute(any());
    }
}