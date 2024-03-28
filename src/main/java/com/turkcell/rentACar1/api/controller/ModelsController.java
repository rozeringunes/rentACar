package com.turkcell.rentACar1.api.controller;

import com.turkcell.rentACar1.business.abstracts.ModelService;
import com.turkcell.rentACar1.business.dtos.requests.models.CreateModelRequest;
import com.turkcell.rentACar1.business.dtos.requests.models.UpdateModelRequest;
import com.turkcell.rentACar1.business.dtos.responses.models.CreatedModelResponse;
import com.turkcell.rentACar1.business.dtos.responses.models.GetAllModelsListItemDto;
import com.turkcell.rentACar1.business.dtos.responses.models.GetModelResponse;
import com.turkcell.rentACar1.business.dtos.responses.models.UpdatedModelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/models")
public class ModelsController {
    private ModelService modelService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedModelResponse add(@RequestBody CreateModelRequest createModelResponse){
        return modelService.add(createModelResponse);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedModelResponse update(@Valid @PathVariable int id, @RequestBody UpdateModelRequest model) {
        return modelService.update(id, model);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        modelService.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetModelResponse get(@PathVariable int id) {
        return modelService.get(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllModelsListItemDto> getAll() {
        return modelService.getAll();
    }
}
