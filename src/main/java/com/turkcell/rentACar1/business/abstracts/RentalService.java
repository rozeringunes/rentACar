package com.turkcell.rentACar1.business.abstracts;

import com.turkcell.rentACar1.business.dtos.requests.maintenances.UpdateMaintenanceRequest;
import com.turkcell.rentACar1.business.dtos.requests.rentals.CreateRentalRequest;
import com.turkcell.rentACar1.business.dtos.requests.rentals.UpdateRentalRequest;
import com.turkcell.rentACar1.business.dtos.responses.rentals.CreatedRentalResponse;
import com.turkcell.rentACar1.business.dtos.responses.rentals.GetAllRentalsListItemDto;
import com.turkcell.rentACar1.business.dtos.responses.rentals.GetRentalResponse;
import com.turkcell.rentACar1.business.dtos.responses.rentals.UpdatedRentalResponse;

import java.util.List;

public interface RentalService {
    CreatedRentalResponse add(CreateRentalRequest createRentalRequest);
    UpdatedRentalResponse update(int id, UpdateRentalRequest updateRentalRequest);
    void delete(int id);
    List<GetAllRentalsListItemDto> getAll();
    GetRentalResponse get (int id);

}
