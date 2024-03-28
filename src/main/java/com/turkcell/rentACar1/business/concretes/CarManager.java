package com.turkcell.rentACar1.business.concretes;

import com.turkcell.rentACar1.business.abstracts.CarService;
import com.turkcell.rentACar1.business.dtos.requests.cars.CreateCarRequest;
import com.turkcell.rentACar1.business.dtos.requests.cars.UpdateCarRequest;
import com.turkcell.rentACar1.business.dtos.responses.cars.CreatedCarResponse;
import com.turkcell.rentACar1.business.dtos.responses.cars.GetAllCarsListItemDto;
import com.turkcell.rentACar1.business.dtos.responses.cars.GetCarResponse;
import com.turkcell.rentACar1.business.dtos.responses.cars.UpdatedCarResponse;
import com.turkcell.rentACar1.business.rules.CarBusinessRules;
import com.turkcell.rentACar1.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentACar1.dataAccess.abstracts.CarRepository;
import com.turkcell.rentACar1.entities.concretes.Car;
import com.turkcell.rentACar1.entities.enums.CarState;
import lombok.AllArgsConstructor;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CarManager implements CarService {
    private final CarRepository carRepository;
    private final ModelMapperService modelMapperService;
    private final CarBusinessRules carBusinessRules;

    @Override
    public CreatedCarResponse add(CreateCarRequest createCarRequest) {
        carBusinessRules.plateShouldBeUnique(createCarRequest.getPlate());
        Car car = modelMapperService.forRequest().map(createCarRequest, Car.class);
        car.setId(0); // model mapper bug
        car.setCreatedDate(LocalDateTime.now());
        car.setState(CarState.AVAILABLE);

        Car createdCar = carRepository.save(car);
        return modelMapperService.forResponse().map(createdCar, CreatedCarResponse.class);
    }



       @Override
public void updateState(int carId, CarState carState) {
        Optional<Car> foundOptionalCar = carRepository.findById(carId);
        carBusinessRules.carShouldBeExist(foundOptionalCar);
        Car car = foundOptionalCar.get();
        car.setState(carState);
        carRepository.save(car);
    }

    @Override
    public UpdatedCarResponse update(int id, UpdateCarRequest updateCarRequest) {
        carBusinessRules.carIdShouldBeExist(id);
        Car carToUpdate = modelMapperService.forRequest().map(updateCarRequest, Car.class);
        carToUpdate.setId(id);
        Car updatedCar = carRepository.save(carToUpdate);
        return modelMapperService.forResponse().map(updatedCar, UpdatedCarResponse.class);
    }

    @Override
    public void delete(int id) {
        Optional<Car> foundOptionalCar = carRepository.findById(id);
        carBusinessRules.carShouldBeExist(foundOptionalCar);
        carRepository.delete(foundOptionalCar.get());
    }

    @Override
    public List<GetAllCarsListItemDto> getAll() {
        List<Car> cars = carRepository.findAll();
        return modelMapperService.forResponse().map(cars, new TypeToken<List<GetAllCarsListItemDto>>() {
        }.getType());
    }

    @Override
    public GetCarResponse get(int id) {
        Optional<Car> foundOptionalCar = carRepository.findById(id);
        carBusinessRules.carShouldBeExist(foundOptionalCar);
        return modelMapperService.forResponse().map(foundOptionalCar.get(), GetCarResponse.class);
    }
}