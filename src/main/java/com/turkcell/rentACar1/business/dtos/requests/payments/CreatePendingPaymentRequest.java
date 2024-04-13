package com.turkcell.rentACar1.business.dtos.requests.payments;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatePendingPaymentRequest {
    @NotNull
    private int rentalId;

    @NotNull
    private double amount;
}
