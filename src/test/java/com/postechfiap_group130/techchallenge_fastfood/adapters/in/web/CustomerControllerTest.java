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

@WebMvcTest(controllers = CustomerController.class)
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FindCustomerByCpfUseCase findCustomerByCpfUseCase;

    private static final String VALID_CPF = "52998224725";
    private static final String INVALID_CPF = "12345678900";

    @Test
    void whenGetCustomerWithValidCpf_thenReturnCustomer() throws Exception {
        // Arrange
        Customer mockCustomer = Customer.builder()
                .id("1")
                .name("João da Silva")
                .cpf(VALID_CPF)
                .email("joao.silva@email.com")
                .build();

        when(findCustomerByCpfUseCase.findByCpf(VALID_CPF)).thenReturn(mockCustomer);

        // Act & Assert
        mockMvc.perform(get("/api/v1/customers/{cpf}", VALID_CPF))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("João da Silva"))
                .andExpect(jsonPath("$.cpf").value(VALID_CPF))
                .andExpect(jsonPath("$.email").value("joao.silva@email.com"));
    }

    @Test
    void whenGetCustomerWithInvalidCpf_thenReturnBadRequest() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/api/v1/customers/{cpf}", INVALID_CPF))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Invalid CPF"))
                .andExpect(jsonPath("$.message").value("Invalid CPF: " + INVALID_CPF));
    }

    @Test
    void whenGetCustomerWithFormattedValidCpf_thenReturnCustomer() throws Exception {
        // Arrange
        String formattedCpf = "529.982.247-25";
        Customer mockCustomer = Customer.builder()
                .id("1")
                .name("João da Silva")
                .cpf(formattedCpf)
                .email("joao.silva@email.com")
                .build();

        when(findCustomerByCpfUseCase.findByCpf(formattedCpf)).thenReturn(mockCustomer);

        // Act & Assert
        mockMvc.perform(get("/api/v1/customers/{cpf}", formattedCpf))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("João da Silva"))
                .andExpect(jsonPath("$.cpf").value(formattedCpf))
                .andExpect(jsonPath("$.email").value("joao.silva@email.com"));
    }

    @Test
    void whenGetCustomerWithNonNumericCpf_thenReturnBadRequest() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/api/v1/customers/{cpf}", "abc.def.ghi-jk"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Invalid CPF"));
    }

    @Test
    void whenGetCustomerWithShortCpf_thenReturnBadRequest() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/api/v1/customers/{cpf}", "1234567890"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Invalid CPF"));
    }

    @Test
    void whenGetCustomerWithLongCpf_thenReturnBadRequest() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/api/v1/customers/{cpf}", "123456789012"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Invalid CPF"));
    }
} 