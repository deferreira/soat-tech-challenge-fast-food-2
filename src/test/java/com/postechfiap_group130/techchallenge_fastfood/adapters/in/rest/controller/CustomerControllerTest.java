package com.postechfiap_group130.techchallenge_fastfood.adapters.in.rest.controller;

import com.postechfiap_group130.techchallenge_fastfood.adapters.in.rest.dto.request.CustomerRequestDto;
import com.postechfiap_group130.techchallenge_fastfood.adapters.in.rest.dto.response.CustomerResponseDto;
import com.postechfiap_group130.techchallenge_fastfood.adapters.in.rest.dto.response.ErrorResponseDto;
import com.postechfiap_group130.techchallenge_fastfood.adapters.in.rest.mapper.CustomerMapper;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.Customer;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.in.RegisterCustomerUseCase;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.in.FindCustomerByCpfUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class CustomerControllerTest {

    private final RegisterCustomerUseCase registerCustomerUseCase = mock(RegisterCustomerUseCase.class);
    private final FindCustomerByCpfUseCase findCustomerByCpfUseCase = mock(FindCustomerByCpfUseCase.class);
    private final CustomerMapper customerMapper = spy(CustomerMapper.class);
    private final CustomerController controller = new CustomerController(registerCustomerUseCase, findCustomerByCpfUseCase, customerMapper);

    @Test
    void create_success() {
        // Arrange
        CustomerRequestDto customerRequestDto = new CustomerRequestDto("Jhon", "jhondoe@gmail.com",
                "12345678", "111.111.111-11");
        // Act
        when(registerCustomerUseCase.execute(any())).thenReturn(Boolean.TRUE);

        ResponseEntity<ErrorResponseDto> result = controller.create(customerRequestDto);

        // Assert
        assertEquals(201, result.getStatusCode().value());
        verify(registerCustomerUseCase).execute(any());
    }

    @Test
    void create_when_email_or_cpf_exists() {
        // Arrange
        CustomerRequestDto customerRequestDto = new CustomerRequestDto("Jhon", "jhondoe@gmail.com",
                "12345678", "111.111.111-11");

        when(registerCustomerUseCase.execute(any())).thenReturn(Boolean.FALSE);

        // Act
        ResponseEntity<ErrorResponseDto> result = controller.create(customerRequestDto);

        // Assert
        assertEquals(400, result.getStatusCode().value());
        assertNotNull(result.getBody());
        assertEquals("Customer já existe", result.getBody().error());
        verify(registerCustomerUseCase).execute(any());
    }

    @Test
    void findByCpf_success() {
        // Arrange
        String cpf = "529.982.247-25";
        Customer mockCustomer = Customer.builder()
                .name("Jhon")
                .email("jhondoe@gmail.com")
                .cpf(cpf)
                .build();
        CustomerResponseDto expectedResponse = new CustomerResponseDto("Jhon", "jhondoe@gmail.com", cpf);
        
        when(findCustomerByCpfUseCase.findByCpf(cpf)).thenReturn(mockCustomer);
        when(customerMapper.toResponseDto(mockCustomer)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<CustomerResponseDto> result = controller.findByCpf(cpf);

        // Assert
        assertNotNull(result);
        assertEquals(200, result.getStatusCode().value());
        assertEquals(expectedResponse, result.getBody());
        verify(findCustomerByCpfUseCase).findByCpf(cpf);
        verify(customerMapper).toResponseDto(mockCustomer);
    }

    @Test
    void findByCpf_notFound() {
        // Arrange
        String cpf = "529.982.247-25";
        when(findCustomerByCpfUseCase.findByCpf(cpf)).thenReturn(null);

        // Act
        ResponseEntity<CustomerResponseDto> result = controller.findByCpf(cpf);

        // Assert
        assertNotNull(result);
        assertEquals(404, result.getStatusCode().value());
        verify(findCustomerByCpfUseCase).findByCpf(cpf);
        verify(customerMapper, never()).toResponseDto(any());
    }
}