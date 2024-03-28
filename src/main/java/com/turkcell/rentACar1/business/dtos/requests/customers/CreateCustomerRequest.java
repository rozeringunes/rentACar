package com.turkcell.rentACar1.business.dtos.requests.customers;

import com.turkcell.rentACar1.entities.enums.CustomerType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {
        @NotNull
        private CustomerType type;
}


