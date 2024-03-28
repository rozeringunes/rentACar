package com.turkcell.rentACar1.business.dtos.responses.corporateCustomers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


    @AllArgsConstructor
    @Data
    @NoArgsConstructor
    public class UpdatedCorporateCustomerResponse {
        private int id;
        private int customerId;
        private String companyName;
        private String taxNo;
        private LocalDateTime createdDate;

    }


