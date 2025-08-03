package com.postechfiap_group130.techchallenge_fastfood.api.rest.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class PaymentRequestDto {

    @NotBlank
    private Long orderId;
    @NotBlank
    private BigDecimal amount;
}
