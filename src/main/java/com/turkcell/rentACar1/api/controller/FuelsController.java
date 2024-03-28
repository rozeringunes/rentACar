package com.turkcell.rentACar1.api.controller;

import com.turkcell.rentACar1.business.abstracts.FuelService;
import com.turkcell.rentACar1.business.dtos.requests.fuels.CreateFuelRequest;
import com.turkcell.rentACar1.business.dtos.requests.fuels.UpdateFuelRequest;
import com.turkcell.rentACar1.business.dtos.responses.fuels.CreatedFuelResponse;
import com.turkcell.rentACar1.business.dtos.responses.fuels.GetAllFuelsListItemDto;
import com.turkcell.rentACar1.business.dtos.responses.fuels.GetFuelResponse;
import com.turkcell.rentACar1.business.dtos.responses.fuels.UpdatedFuelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fuels")
public class FuelsController {
    private FuelService fuelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedFuelResponse add(@Valid @RequestBody CreateFuelRequest fuel) {
        return fuelService.add(fuel);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedFuelResponse update(@Valid @PathVariable int id, @RequestBody UpdateFuelRequest fuel) {
        return fuelService.update(id, fuel);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        fuelService.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetFuelResponse get(@PathVariable int id) {
        return fuelService.get(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllFuelsListItemDto> getAll() {
        return fuelService.getAll();
    }
}