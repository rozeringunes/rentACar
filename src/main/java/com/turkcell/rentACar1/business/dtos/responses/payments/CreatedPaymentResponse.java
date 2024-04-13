package com.turkcell.rentACar1.business.dtos.responses.payments;

import com.turkcell.rentACar1.entities.enums.PaymentState;
import lombok.Data;

@Data
public class CreatedPaymentResponse {
    private int id;
    private PaymentState state;
}
