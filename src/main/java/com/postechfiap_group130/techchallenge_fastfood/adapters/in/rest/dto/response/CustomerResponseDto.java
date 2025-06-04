package com.postechfiap_group130.techchallenge_fastfood.adapters.in.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponseDto {
    private String name;
    private String email;
    private String cpf;
} 