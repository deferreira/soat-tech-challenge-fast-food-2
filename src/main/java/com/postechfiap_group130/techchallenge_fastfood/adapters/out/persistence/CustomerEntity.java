package com.postechfiap_group130.techchallenge_fastfood.adapters.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
@Data
public class CustomerEntity {

    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
    private String cpf;

}
