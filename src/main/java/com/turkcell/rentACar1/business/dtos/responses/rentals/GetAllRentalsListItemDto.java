package com.turkcell.rentACar1.business.dtos.responses.rentals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;



    @AllArgsConstructor
    @Data
    @NoArgsConstructor
    public class GetAllRentalsListItemDto {
        private int id;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private LocalDateTime returnDate;
        private int carId;
        private int customerId;
        private LocalDateTime createdDate;
    }
