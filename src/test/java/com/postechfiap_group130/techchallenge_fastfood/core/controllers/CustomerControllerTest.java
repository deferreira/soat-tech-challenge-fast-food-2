package com.postechfiap_group130.techchallenge_fastfood.core.controllers;

import com.postechfiap_group130.techchallenge_fastfood.api.rest.dto.request.CustomerRequestDto;
import com.postechfiap_group130.techchallenge_fastfood.api.rest.dto.response.CustomerResponseDto;
import com.postechfiap_group130.techchallenge_fastfood.core.interfaces.DataSource;
import com.postechfiap_group130.techchallenge_fastfood.domain.exception.ErrorException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CustomerControllerTest {

    DataSource dataSource = Mockito.mock(DataSource.class);

    CustomerController customerController = new CustomerController(dataSource);

    @Test
    void createCustomerSuccess() {
        // Arrange
        CustomerRequestDto customerRequestDto = new CustomerRequestDto("Jhon", "jhondoe@gmail.com",
                "12345678", "111.111.111-11");

        // Act
        CustomerResponseDto result = customerController.createCustomer(customerRequestDto);

        // Assert
        assertNotNull(result);
        verify(dataSource).existsByEmailOrCpf(anyString(), anyString());
        verify(dataSource).save(any());

    }

    @Test
    void createCustomer_fail_when_customer_exists() {
        // Arrange
        CustomerRequestDto customerRequestDto = new CustomerRequestDto("Jhon", "jhondoe@gmail.com",
                "12345678", "111.111.111-11");

        when(dataSource.existsByEmailOrCpf(anyString(), anyString())).thenReturn(Boolean.TRUE);

        // Act
        var ex = assertThrows(ErrorException.class, () -> customerController.createCustomer(customerRequestDto));

        // Assert
        assertEquals("Customer already exists with EMAIL or CPF", ex.getMessage());
        verify(dataSource).existsByEmailOrCpf(anyString(), anyString());

    }
}