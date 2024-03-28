package com.turkcell.rentACar1.business.dtos.responses.transmissions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class UpdatedTransmissionResponse {
        private int id;
        private String name;
        private Double dailyPrice;
        private int brandId;
        private int fuelId;
        private int transmissionId;
        private LocalDateTime createdDate;
    }


