package com.postechfiap_group130.techchallenge_fastfood.application.useCases;

import com.postechfiap_group130.techchallenge_fastfood.domain.model.Customer;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.in.RegisterCustomerUseCase;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.out.CustomerRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RegisterCustomerUseCaseImplTest {

    private final CustomerRepository customerRepository = mock(CustomerRepository.class);
    private final RegisterCustomerUseCase registerCustomerUseCase = new RegisterCustomerUseCaseImpl(customerRepository);

    @Test
    void execute_success() {
        // Arrange
        Customer customer = Customer.builder()
                .name("Jhon")
                .email("jhondoe@gmail.com")
                .password("12345678")
                .cpf("111.111.111-11")
                .build();

        when(customerRepository.existsByEmailOrCpf(anyString(), anyString())).thenReturn(Boolean.FALSE);

        // Act
        Boolean result = registerCustomerUseCase.execute(customer);

        // Assert
        assertTrue(result);
        verify(customerRepository).existsByEmailOrCpf(anyString(), anyString());
        verify(customerRepository).save(customer);
    }

    @Test
    void execute_when_customer_exists() {
        // Arrange
        Customer customer = Customer.builder()
                .name("Jhon")
                .email("jhondoe@gmail.com")
                .password("12345678")
                .cpf("111.111.111-11")
                .build();

        when(customerRepository.existsByEmailOrCpf(anyString(), anyString())).thenReturn(Boolean.TRUE);

        // Act
        Boolean result = registerCustomerUseCase.execute(customer);

        // Assert
        assertFalse(result);
        verify(customerRepository).existsByEmailOrCpf(anyString(), anyString());
    }
}