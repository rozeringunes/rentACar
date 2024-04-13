package com.turkcell.rentACar1.business.dtos.responses.payments;

import com.turkcell.rentACar1.entities.enums.PaymentState;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetAllPaymentsListItemDto {
    private int rentalId;
    private PaymentState state;
    private double amount;
    private LocalDateTime paymentDate;

}
