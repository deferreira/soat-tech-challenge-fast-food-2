package com.postechfiap_group130.techchallenge_fastfood.adapters.in.web;

import com.postechfiap_group130.techchallenge_fastfood.domain.exception.InvalidCpfException;
import com.postechfiap_group130.techchallenge_fastfood.domain.model.Customer;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.in.FindCustomerByCpfUseCase;
import com.postechfiap_group130.techchallenge_fastfood.domain.validation.CpfValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
@Tag(name = "Customer", description = "API for customer management")
public class CustomerController {

    private final FindCustomerByCpfUseCase findCustomerByCpfUseCase;

    @Operation(summary = "Search Customer by CPF", description = "Return the customer data based on the CPF informed")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Customer found",
            content = @Content(schema = @Schema(implementation = Customer.class))),
        @ApiResponse(responseCode = "400", description = "Invalid CPF"),
        @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    @GetMapping("/{cpf}")
    public ResponseEntity<Customer> findByCpf(
            @Parameter(description = "Customer CPF (Just numbers or formatted)") 
            @PathVariable String cpf) {
        if (!CpfValidator.isValid(cpf)) {
            throw new InvalidCpfException("Invalid CPF: " + cpf);
        }
        
        Customer customer = findCustomerByCpfUseCase.findByCpf(cpf);
        return customer != null ? ResponseEntity.ok(customer) : ResponseEntity.notFound().build();
    }
}
