package com.turkcell.rentACar1.business.dtos.responses.transmissions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class GetTransmissionResponse {
        private int id;
        private String name;
        private LocalDateTime createdDate;
    }