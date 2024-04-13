package com.turkcell.rentACar1.business.dtos.requests.pos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
    private String cardNumber;
    private String cardHolder;
    private String cvv;
    private String expirationYear;
    private String expirationMonth;
    private double amount;
}
