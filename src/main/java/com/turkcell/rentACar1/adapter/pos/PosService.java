package com.turkcell.rentACar1.adapter.pos;

import com.turkcell.rentACar1.business.dtos.requests.payments.CreatePaymentRequest;
import com.turkcell.rentACar1.business.dtos.requests.pos.PaymentRequest;

public interface PosService {
    boolean pay(PaymentRequest paymentRequest);
}
