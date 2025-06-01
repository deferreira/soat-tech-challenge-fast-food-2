package com.postechfiap_group130.techchallenge_fastfood.adapters.in.web;

import com.postechfiap_group130.techchallenge_fastfood.domain.model.Customer;
import com.postechfiap_group130.techchallenge_fastfood.domain.ports.in.FindCustomerByCpfUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final FindCustomerByCpfUseCase findCustomerByCpfUseCase;

    @GetMapping("/{cpf}")
    public ResponseEntity<Customer> findByCpf(@PathVariable String cpf) {
        Customer customer = findCustomerByCpfUseCase.findByCpf(cpf);
        return customer != null ? ResponseEntity.ok(customer) : ResponseEntity.notFound().build();
    }
}
