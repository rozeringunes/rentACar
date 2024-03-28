package com.turkcell.rentACar1.business.dtos.responses.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;



    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class GetModelResponse {
        private int id;
        private String name;
        private int brandId;
        private int fuelId;
        private int transmission;
        private LocalDateTime createdDate;
    }