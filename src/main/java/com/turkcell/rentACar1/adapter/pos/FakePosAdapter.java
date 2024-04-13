package com.turkcell.rentACar1.adapter.pos;

import com.turkcell.rentACar1.business.dtos.requests.pos.PaymentRequest;
import com.turkcell.rentACar1.entities.outServices.FakePosClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FakePosAdapter implements PosService {
    private final FakePosClient fakePosClient
;

    @Override
    public boolean pay(PaymentRequest paymentRequest) {
        String expireDate = paymentRequest.getExpirationMonth() + "/" + paymentRequest.getExpirationYear();
        return fakePosClient.createPayment(paymentRequest.getCardNumber(), paymentRequest.getCardHolder(), paymentRequest.getCvv(), expireDate, paymentRequest.getAmount());
    }
}
