package com.postechfiap_group130.techchallenge_fastfood.core.controllers;

import com.postechfiap_group130.techchallenge_fastfood.api.rest.dto.request.UpdatePaymentRequestDto;
import com.postechfiap_group130.techchallenge_fastfood.core.dtos.PaymentDto;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.PaymentStatusEnum;
import com.postechfiap_group130.techchallenge_fastfood.core.interfaces.DataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PaymentControllerTest {

    private PaymentController paymentController;
    private DataSource dataSource;

    @BeforeEach
    void setUp() {
        dataSource = mock(DataSource.class);
        paymentController = new PaymentController(dataSource);
    }

    @Test
    @DisplayName("Must return status APPROVED when payment is approved")
    void shouldReturnApprovedStatus() {
        Long paymentId = 1L;
        when(dataSource.findPaymentById(paymentId)).thenReturn(Optional.of(
            new PaymentDto(paymentId, 1L, new BigDecimal("100.00"), PaymentStatusEnum.APPROVED)
        ));

        PaymentDto result = paymentController.checkPaymentStatus(paymentId);

        assertNotNull(result);
        assertEquals(paymentId, result.id());
        assertEquals(PaymentStatusEnum.APPROVED, result.status());

        verify(dataSource).findPaymentById(paymentId);
    }

    @Test
    @DisplayName("Must return status REJECTED when payment is rejected")
    void shouldReturnRejectedStatus() {
        Long paymentId = 4L;
        when(dataSource.findPaymentById(paymentId)).thenReturn(Optional.of(
            new PaymentDto(paymentId, 1L, new BigDecimal("50.00"), PaymentStatusEnum.REJECTED)
        ));

        PaymentDto result = paymentController.checkPaymentStatus(paymentId);

        assertNotNull(result);
        assertEquals(paymentId, result.id());
        assertEquals(PaymentStatusEnum.REJECTED, result.status());

        verify(dataSource).findPaymentById(paymentId);
    }

    @Test
    @DisplayName("Must return status NOT_FOUND when payment does not exist")
    void shouldReturnNotFoundWhenPaymentDoesNotExist() {
        Long paymentId = 999L;
        when(dataSource.findPaymentById(paymentId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            paymentController.checkPaymentStatus(paymentId);
        });
        
        verify(dataSource).findPaymentById(paymentId);
    }

    @Test
    @DisplayName("Should update payment status successfully")
    void shouldUpdatePaymentStatusSuccessfully() {
        Long paymentId = 1L;
        String newStatus = "APPROVED";
        UpdatePaymentRequestDto requestDto = new UpdatePaymentRequestDto(newStatus);
        
        PaymentDto expectedDto = new PaymentDto(
            paymentId, 
            1L, 
            new BigDecimal("100.00"), 
            PaymentStatusEnum.APPROVED
        );
        
        when(dataSource.updatePaymentStatus(any())).thenReturn(expectedDto);

        PaymentDto result = paymentController.updatePayment(paymentId, requestDto);

        assertNotNull(result);
        assertEquals(paymentId, result.id());
        assertEquals(PaymentStatusEnum.APPROVED, result.status());
        verify(dataSource).updatePaymentStatus(any());
    }
} 