package com.turkcell.rentACar1.business.dtos.requests.transmissions;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateTransmissionRequest {
    @NotNull
    @Size(min=2,max=30)
    private String name;
}
