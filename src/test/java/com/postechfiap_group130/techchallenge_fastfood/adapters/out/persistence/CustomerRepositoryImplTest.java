package com.postechfiap_group130.techchallenge_fastfood.adapters.out.persistence;

import com.postechfiap_group130.techchallenge_fastfood.domain.model.Customer;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.out.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerRepositoryImplTest {

    private final CustomerJpaRepository customerJpaRepository = mock(CustomerJpaRepository.class);
    private final PasswordEncoder passwordEncoder = spy(PasswordEncoder.class);
    private final CustomerRepository customerRepository = new CustomerRepositoryImpl(customerJpaRepository, passwordEncoder);

    @Test
    void save_success() {
        // Arrange
        Customer customer = new Customer("Jhon", "jhondoe@gmail.com",
                "12345678", "111.111.111-11");

        // Act
        customerRepository.save(customer);

        // Assert
        verify(passwordEncoder).encode(anyString());
        verify(customerJpaRepository).save(any());
    }

    @Test
    void existsByEmailOrCpf_success_when_Customer_Exists() {
        // Arrange
        Customer customer = new Customer("Jhon", "jhondoe@gmail.com",
                "12345678", "111.111.111-11");

        when(customerJpaRepository.existsByEmailOrCpf(anyString(), anyString())).thenReturn(true);


        // Act
        Boolean result = customerRepository.existsByEmailOrCpf(customer.getEmail(), customer.getCpf());

        // Assert
        assertEquals(Boolean.TRUE, result);
        verify(customerJpaRepository).existsByEmailOrCpf(anyString(), anyString());

    }

    @Test
    void existsByEmailOrCpf_success_when_Customer_dont_Exists() {
        // Arrange
        Customer customer = new Customer("Jhon", "jhondoe@gmail.com",
                "12345678", "111.111.111-11");

        when(customerJpaRepository.existsByEmailOrCpf(anyString(), anyString())).thenReturn(false);


        // Act
        Boolean result = customerRepository.existsByEmailOrCpf(customer.getEmail(), customer.getCpf());

        // Assert
        assertEquals(Boolean.FALSE, result);
        verify(customerJpaRepository).existsByEmailOrCpf(anyString(), anyString());

    }
}
