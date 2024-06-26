package com.turkcell.rentACar1.api.controller;

import com.turkcell.rentACar1.business.abstracts.CarService;
import com.turkcell.rentACar1.business.dtos.requests.cars.CreateCarRequest;
import com.turkcell.rentACar1.business.dtos.requests.cars.UpdateCarRequest;
import com.turkcell.rentACar1.business.dtos.responses.cars.CreatedCarResponse;
import com.turkcell.rentACar1.business.dtos.responses.cars.GetAllCarsListItemDto;
import com.turkcell.rentACar1.business.dtos.responses.cars.GetCarResponse;
import com.turkcell.rentACar1.business.dtos.responses.cars.UpdatedCarResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/cars")
public class CarsController {
    private CarService carService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCarResponse add(@Valid @RequestBody CreateCarRequest createCarRequest) {
        return carService.add(createCarRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedCarResponse update(@PathVariable int id, @Valid @RequestBody UpdateCarRequest car) {
        return carService.update(id, car);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        carService.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetCarResponse get(@PathVariable int id) {
        return carService.get(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllCarsListItemDto> getAll() {
        return carService.getAll();
    }
}