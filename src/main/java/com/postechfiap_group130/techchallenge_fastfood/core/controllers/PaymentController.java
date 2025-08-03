package com.postechfiap_group130.techchallenge_fastfood.core.controllers;

import com.postechfiap_group130.techchallenge_fastfood.core.dtos.PaymentDto;
import com.postechfiap_group130.techchallenge_fastfood.core.entities.Payment;
import com.postechfiap_group130.techchallenge_fastfood.core.gateways.PaymentGateway;
import com.postechfiap_group130.techchallenge_fastfood.core.interfaces.DataSource;
import com.postechfiap_group130.techchallenge_fastfood.core.presenters.PaymentPresenter;
import com.postechfiap_group130.techchallenge_fastfood.core.usecases.CheckPaymentStatusUseCase;

public class PaymentController {

    private final DataSource dataSource;

    public PaymentController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public PaymentDto checkPaymentStatus(Long paymentId) {
        PaymentGateway paymentGateway = new PaymentGateway(dataSource);
        CheckPaymentStatusUseCase checkPaymentStatusUseCase = new CheckPaymentStatusUseCase(paymentGateway);
        Payment payment = checkPaymentStatusUseCase.execute(paymentId);
        return PaymentPresenter.toDto(payment);
    }
}