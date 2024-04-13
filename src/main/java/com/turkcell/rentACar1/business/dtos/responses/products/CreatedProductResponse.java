package com.turkcell.rentACar1.business.dtos.responses.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatedProductResponse {
    private int id;
    private String name;
    private double dailyPrice;
    private LocalDateTime createdDate;

}
