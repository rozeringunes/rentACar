package com.turkcell.rentACar1.business.dtos.requests.individualCustomers;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class UpdateIndividualCustomerRequest {
        @NotNull
        @Size(min=2,max=30)
        private String firstName;

        @NotNull
        @Size(min=2,max=30)
        private String lastName;

        @NotNull
        @Size(min=11,max=11)
        private  String identityNumber;

        @NotNull
        private LocalDateTime birthDate;

    }
