package com.postechfiap_group130.techchallenge_fastfood.api.rest.controller;

import com.postechfiap_group130.techchallenge_fastfood.api.data.DataRepository;
import com.postechfiap_group130.techchallenge_fastfood.core.dtos.PaymentDto;
import com.postechfiap_group130.techchallenge_fastfood.core.controllers.PaymentController;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.PaymentStatusEnum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentResource {

    private final DataRepository dataRepository;

    public PaymentResource(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @GetMapping("/{paymentId}/status")
    public ResponseEntity<PaymentStatusEnum> checkPaymentStatus(@PathVariable Long paymentId) {
        PaymentController paymentController = new PaymentController(dataRepository);
        PaymentDto result = paymentController.checkPaymentStatus(paymentId);

        return result != null ? ResponseEntity.ok(result.status()) : ResponseEntity.notFound().build();
    }
} 