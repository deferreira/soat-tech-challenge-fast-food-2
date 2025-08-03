package com.postechfiap_group130.techchallenge_fastfood.api.rest.controller;

import com.postechfiap_group130.techchallenge_fastfood.api.data.DataRepository;
import com.postechfiap_group130.techchallenge_fastfood.api.rest.dto.request.UpdatePaymentRequestDto;
import com.postechfiap_group130.techchallenge_fastfood.core.dtos.PaymentDto;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.PaymentStatusEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentResourceTest {

    @Mock
    private DataRepository dataRepository;

    @InjectMocks
    private PaymentResource paymentResource;

    @Test
    void updatePayment_ShouldReturnOk_WhenUpdateIsSuccessful() {
        Long paymentId = 1L;
        UpdatePaymentRequestDto requestDto = new UpdatePaymentRequestDto("APPROVED");
        PaymentDto paymentDto = new PaymentDto(
            paymentId,
            1L,
            new BigDecimal("100.00"),
            PaymentStatusEnum.APPROVED
        );

        when(dataRepository.updatePaymentStatus(any())).thenReturn(paymentDto);

        ResponseEntity<PaymentDto> response = paymentResource.updatePayment(paymentId, requestDto);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(paymentId, response.getBody().id());
        assertEquals(PaymentStatusEnum.APPROVED, response.getBody().status());
    }

    @Test
    void updatePayment_ShouldReturnNotFound_WhenPaymentDoesNotExist() {
        Long paymentId = 999L;
        UpdatePaymentRequestDto requestDto = new UpdatePaymentRequestDto("APPROVED");
        when(dataRepository.updatePaymentStatus(any())).thenReturn(null);

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> {
            paymentResource.updatePayment(paymentId, requestDto);
        });
        
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusCode());
        assertEquals("404 NOT_FOUND \"Payment not found\"", exception.getMessage());
    }
}
