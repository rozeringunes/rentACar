package com.turkcell.rentACar1.business.abstracts;

import com.turkcell.rentACar1.business.dtos.requests.fuels.CreateFuelRequest;
import com.turkcell.rentACar1.business.dtos.requests.fuels.UpdateFuelRequest;
import com.turkcell.rentACar1.business.dtos.responses.fuels.CreatedFuelResponse;
import com.turkcell.rentACar1.business.dtos.responses.fuels.GetAllFuelsListItemDto;
import com.turkcell.rentACar1.business.dtos.responses.fuels.GetFuelResponse;
import com.turkcell.rentACar1.business.dtos.responses.fuels.UpdatedFuelResponse;

import java.util.List;

public interface FuelService {
    CreatedFuelResponse add(CreateFuelRequest createFuelRequest);
    UpdatedFuelResponse update(int id, UpdateFuelRequest createFuelRequest);
    void delete (int id);
    List<GetAllFuelsListItemDto> getAll();
    GetFuelResponse get(int id);


}
