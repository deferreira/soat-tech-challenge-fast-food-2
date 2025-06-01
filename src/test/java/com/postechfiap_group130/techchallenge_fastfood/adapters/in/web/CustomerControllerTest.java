package com.postechfiap_group130.techchallenge_fastfood.adapters.in.web;

import com.postechfiap_group130.techchallenge_fastfood.domain.model.Customer;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.in.FindCustomerByCpfUseCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FindCustomerByCpfUseCase findCustomerByCpfUseCase;

    private static final String TEST_CPF = "12345678900";

    @Test
    void whenGetCustomerByCpf_thenReturnCustomer() throws Exception {
        // Arrange
        Customer mockCustomer = Customer.builder()
                .id("1")
                .name("João da Silva")
                .cpf(TEST_CPF)
                .email("joao.silva@email.com")
                .build();

        when(findCustomerByCpfUseCase.findByCpf(TEST_CPF)).thenReturn(mockCustomer);

        // Act & Assert
        mockMvc.perform(get("/api/v1/customers/{cpf}", TEST_CPF))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("João da Silva"))
                .andExpect(jsonPath("$.cpf").value(TEST_CPF))
                .andExpect(jsonPath("$.email").value("joao.silva@email.com"));
    }

    @Test
    void whenGetCustomerByCpf_thenReturnNotFound() throws Exception {
        // Arrange
        when(findCustomerByCpfUseCase.findByCpf(TEST_CPF)).thenReturn(null);

        // Act & Assert
        mockMvc.perform(get("/api/v1/customers/{cpf}", TEST_CPF))
                .andExpect(status().isNotFound());
    }
} 