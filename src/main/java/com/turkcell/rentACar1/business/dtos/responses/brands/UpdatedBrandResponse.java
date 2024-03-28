package com.turkcell.rentACar1.business.dtos.responses.brands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedBrandResponse {
    private int id;
    private String name;
    private LocalDateTime createdDate;
}
