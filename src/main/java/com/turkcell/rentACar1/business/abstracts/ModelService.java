package com.turkcell.rentACar1.business.abstracts;

import com.turkcell.rentACar1.business.dtos.requests.models.CreateModelRequest;
import com.turkcell.rentACar1.business.dtos.requests.models.UpdateModelRequest;
import com.turkcell.rentACar1.business.dtos.responses.models.CreatedModelResponse;
import com.turkcell.rentACar1.business.dtos.responses.models.GetAllModelsListItemDto;
import com.turkcell.rentACar1.business.dtos.responses.models.GetModelResponse;
import com.turkcell.rentACar1.business.dtos.responses.models.UpdatedModelResponse;

import java.util.List;

public interface ModelService {
    CreatedModelResponse add(CreateModelRequest createModelRequest);

    UpdatedModelResponse update(int id, UpdateModelRequest updateModelRequest);

    void delete(int id);

    List<GetAllModelsListItemDto> getAll();

    GetModelResponse get(int id);
}