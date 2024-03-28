package com.turkcell.rentACar1.business.dtos.responses.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreatedModelResponse {
private int id;
private String name;
private int brandId;
private int fuelId;
private int transmissionId;
private LocalDateTime createdDate;


}
