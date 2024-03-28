package com.turkcell.rentACar1.business.abstracts;

import com.turkcell.rentACar1.business.dtos.requests.maintenances.CreateMaintenanceRequest;
import com.turkcell.rentACar1.business.dtos.requests.maintenances.UpdateMaintenanceRequest;
import com.turkcell.rentACar1.business.dtos.responses.maintenances.CreatedMaintenanceResponse;
import com.turkcell.rentACar1.business.dtos.responses.maintenances.GetAllMaintenancesListItemDto;
import com.turkcell.rentACar1.business.dtos.responses.maintenances.GetMaintenanceResponse;
import com.turkcell.rentACar1.business.dtos.responses.maintenances.UpdatedMaintenanceResponse;

import java.util.List;

public interface MaintenanceService {
    CreatedMaintenanceResponse add(CreateMaintenanceRequest createMaintenanceRequest);
    UpdatedMaintenanceResponse update(int id, UpdateMaintenanceRequest updateMaintenanceRequest);
    void delete(int id);
    List<GetAllMaintenancesListItemDto> getAll();
    GetMaintenanceResponse get(int id);


}
