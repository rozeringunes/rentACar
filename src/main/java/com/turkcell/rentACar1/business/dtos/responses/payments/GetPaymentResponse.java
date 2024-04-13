package com.turkcell.rentACar1.business.dtos.responses.payments;

import com.turkcell.rentACar1.entities.enums.PaymentState;

import java.time.LocalDateTime;

public class GetPaymentResponse {
    private int rentalId;
    private PaymentState state;
    private double amount;
    private LocalDateTime paymentDate;

}
