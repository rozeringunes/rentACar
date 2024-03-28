package com.turkcell.rentACar1.business.abstracts;

import com.turkcell.rentACar1.business.dtos.requests.transmissions.CreateTransmissionRequest;
import com.turkcell.rentACar1.business.dtos.requests.transmissions.UpdateTransmissionRequest;
import com.turkcell.rentACar1.business.dtos.responses.transmissions.CreatedTransmissionResponse;
import com.turkcell.rentACar1.business.dtos.responses.transmissions.GetAllTransmissionsListItemDto;
import com.turkcell.rentACar1.business.dtos.responses.transmissions.GetTransmissionResponse;
import com.turkcell.rentACar1.business.dtos.responses.transmissions.UpdatedTransmissionResponse;

import java.util.List;

public interface TransmissionService {
    CreatedTransmissionResponse add(CreateTransmissionRequest createTransmissionRequest);

    UpdatedTransmissionResponse update(int id, UpdateTransmissionRequest updateTransmissionRequest);

    void delete(int id);

    List<GetAllTransmissionsListItemDto> getAll();

    GetTransmissionResponse get(int id);
}

