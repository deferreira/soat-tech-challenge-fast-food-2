package com.postechfiap_group130.techchallenge_fastfood.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    private String id;
    private String name;
    private String cpf;
    private String email;
} 