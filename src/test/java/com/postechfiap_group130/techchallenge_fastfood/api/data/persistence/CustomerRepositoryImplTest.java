package com.postechfiap_group130.techchallenge_fastfood.api.data.persistence;

import com.postechfiap_group130.techchallenge_fastfood.api.data.jpa.CustomerEntity;
import com.postechfiap_group130.techchallenge_fastfood.api.data.jpa.CustomerJpaRepository;
import com.postechfiap_group130.techchallenge_fastfood.api.data.old.repository.CustomerRepositoryImpl;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerRepositoryImplTest {

//    private final CustomerJpaRepository customerJpaRepository = mock(CustomerJpaRepository.class);
//    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//    private final CustomerRepositoryImpl repository = new CustomerRepositoryImpl(customerJpaRepository, passwordEncoder);
//
//    @Test
//    void save_success() {
//        // Arrange
//        Customer customer = Customer.builder()
//                .name("Jhon")
//                .email("jhondoe@gmail.com")
//                .password("12345678")
//                .cpf("111.111.111-11")
//                .build();
//
//        // Act
//        repository.save(customer);
//
//        // Assert
//        verify(customerJpaRepository).save(any(CustomerEntity.class));
//    }
//
//    @Test
//    void existsByEmailOrCpf_success_when_Customer_Exists() {
//        // Arrange
//        String email = "jhondoe@gmail.com";
//        String cpf = "111.111.111-11";
//        when(customerJpaRepository.existsByEmailOrCpf(email, cpf)).thenReturn(true);
//
//        // Act
//        boolean result = repository.existsByEmailOrCpf(email, cpf);
//
//        // Assert
//        assertTrue(result);
//        verify(customerJpaRepository).existsByEmailOrCpf(email, cpf);
//    }
//
//    @Test
//    void existsByEmailOrCpf_success_when_Customer_dont_Exists() {
//        // Arrange
//        String email = "jhondoe@gmail.com";
//        String cpf = "111.111.111-11";
//        when(customerJpaRepository.existsByEmailOrCpf(email, cpf)).thenReturn(false);
//
//        // Act
//        boolean result = repository.existsByEmailOrCpf(email, cpf);
//
//        // Assert
//        assertFalse(result);
//        verify(customerJpaRepository).existsByEmailOrCpf(email, cpf);
//    }
//
//    @Test
//    void findByCpf_success() {
//        // Arrange
//        String cpf = "111.111.111-11";
//        CustomerEntity entity = new CustomerEntity();
//        entity.setId("ad81af4a-c169-4c6b-be80-6ec5ba3409e1");
//        entity.setName("Jhon");
//        entity.setEmail("jhondoe@gmail.com");
//        entity.setPassword("12345678");
//        entity.setCpf(cpf);
//
//        when(customerJpaRepository.findByCpf(cpf)).thenReturn(entity);
//
//        // Act
//        Customer result = repository.findByCpf(cpf);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals("ad81af4a-c169-4c6b-be80-6ec5ba3409e1", result.getId());
//        assertEquals("Jhon", result.getName());
//        assertEquals("jhondoe@gmail.com", result.getEmail());
//        assertEquals("12345678", result.getPassword());
//        assertEquals(cpf, result.getCpf());
//        verify(customerJpaRepository).findByCpf(cpf);
//    }
//
//    @Test
//    void findByCpf_notFound() {
//        // Arrange
//        String cpf = "111.111.111-11";
//        when(customerJpaRepository.findByCpf(cpf)).thenReturn(null);
//
//        // Act
//        Customer result = repository.findByCpf(cpf);
//
//        // Assert
//        assertNull(result);
//        verify(customerJpaRepository).findByCpf(cpf);
//    }
}
