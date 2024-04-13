package com.turkcell.rentACar1.business.dtos.requests.payments;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompletePaymentWithCarRequest {
    @NotNull
    private int id;
    @NotNull
    private CreditCardDto creditCardDto;
}
