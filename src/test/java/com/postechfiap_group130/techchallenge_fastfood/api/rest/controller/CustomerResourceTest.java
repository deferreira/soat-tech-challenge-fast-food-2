package com.postechfiap_group130.techchallenge_fastfood.api.rest.controller;

class CustomerResourceTest {
//    // Nao consegui testar utilizando mocks, pois ao rodar o test internamente é criada uma nova instancia de cada objeto usado.
//
//    private final DataRepository dataRepository = mock(DataRepository.class);
////    private final CustomerResource customerResource = new CustomerResource(findCustomerByCpfUseCase, customerMapper, dataRepository);
//
//    @Test
//    void create_success() {
//        // Arrange
//        CustomerRequestDto customerRequestDto = new CustomerRequestDto("Jhon", "jhondoe@gmail.com",
//                "12345678", "111.111.111-11");
//        CustomerResponseDto customerResponseDto = new CustomerResponseDto("ad81af4a-c169-4c6b-be80-6ec5ba3409e1",
//                "Jhon", "jhondoe@gmail.com", "111.111.111-11");
//
//        // Act
//        ResponseEntity<CustomerResponseDto> result = customerResource.create(customerRequestDto);
//
//        // Assert
//        assertEquals(201, result.getStatusCode().value());
//    }
//
//    @Test
//    void create_when_email_or_cpf_exists() {
//        // Arrange
//        CustomerRequestDto customerRequestDto = new CustomerRequestDto("Jhon", "jhondoe@gmail.com",
//                "12345678", "111.111.111-11");
//
//        // Act
//        ErrorException ex = assertThrows(ErrorException.class, () -> customerResource.create(customerRequestDto));
//
//        // Assert
//        assertNotNull(ex);
//        assertEquals("Customer already exists with EMAIL or CPF", ex.getMessage());
//    }
//
//    @Test
//    void findByCpf_success() {
//        // Arrange
//        String cpf = "529.982.247-25";
//        Customer mockCustomer = Customer.builder()
//                .name("Jhon")
//                .email("jhondoe@gmail.com")
//                .cpf(cpf)
//                .build();
//        CustomerResponseDto expectedResponse = new CustomerResponseDto("ad81af4a-c169-4c6b-be80-6ec5ba3409e1", "Jhon", "jhondoe@gmail.com", cpf);
//
//        when(findCustomerByCpfUseCase.findByCpf(cpf)).thenReturn(mockCustomer);
//        when(customerMapper.toResponseDto(mockCustomer)).thenReturn(expectedResponse);
//
//        // Act
//        ResponseEntity<CustomerResponseDto> result = customerResource.findByCpf(cpf);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(200, result.getStatusCode().value());
//        assertEquals(expectedResponse, result.getBody());
//        verify(findCustomerByCpfUseCase).findByCpf(cpf);
//        verify(customerMapper).toResponseDto(mockCustomer);
//    }
//
//    @Test
//    void findByCpf_notFound() {
//        // Arrange
//        String cpf = "529.982.247-25";
//        when(findCustomerByCpfUseCase.findByCpf(cpf)).thenReturn(null);
//
//        // Act
//        ResponseEntity<CustomerResponseDto> result = customerResource.findByCpf(cpf);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(404, result.getStatusCode().value());
//        verify(findCustomerByCpfUseCase).findByCpf(cpf);
//        verify(customerMapper, never()).toResponseDto(any());
//    }
}