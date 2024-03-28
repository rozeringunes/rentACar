package com.turkcell.rentACar1.business.dtos.responses.cars;

import com.turkcell.rentACar1.entities.enums.CarState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class GetAllCarsListItemDto {
        private int id;
        private int modelYear;
        private String plate;
        private CarState state;
        private double dailyPrice;
        private int minFindeksScore;
        private int modelId;
        private LocalDateTime createdDate;
    }
