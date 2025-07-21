package com.postechfiap_group130.techchallenge_fastfood.core.gateways;

import com.postechfiap_group130.techchallenge_fastfood.core.interfaces.DataSource;
import com.postechfiap_group130.techchallenge_fastfood.core.dtos.CustomerDto;
import com.postechfiap_group130.techchallenge_fastfood.core.interfaces.ICustomerGateway;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.Customer;

public class CustomerGateway implements ICustomerGateway {

    private final DataSource dataSource;

    public CustomerGateway(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    // Recebe uma entidade do Domain transforma em DTO para o dataSource.
    // O dataSource recebe o DTO e transforma em entity do JPA para salvar no banco.
    @Override
    public void save(Customer customer) {
        CustomerDto customerDto = new CustomerDto(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getCpf(),
                customer.getPassword());

        dataSource.save(customerDto);
    }

    @Override
    public boolean existsByEmailOrCpf(String email, String cpf) {
        boolean result = dataSource.existsByEmailOrCpf(email, cpf);

        return result;
    }

    @Override
    public Customer findByCpf(String cpf) {

        CustomerDto customerDto = dataSource.findByCpf(cpf);
        if (customerDto == null) {
            return null;
        }

        Customer customer = new Customer(
                customerDto.id(),
                customerDto.name(),
                customerDto.email(),
                customerDto.cpf(),
                customerDto.password());

        return customer;
    }
}
