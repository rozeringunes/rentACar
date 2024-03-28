package com.turkcell.rentACar1.business.rules;

import com.turkcell.rentACar1.business.constants.messages.CarMessages;
import com.turkcell.rentACar1.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentACar1.dataAccess.abstracts.CarRepository;
import com.turkcell.rentACar1.entities.concretes.Car;
import com.turkcell.rentACar1.entities.enums.CarState;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CarBusinessRules {
    private final CarRepository carRepository;

    public void carShouldBeExist(Optional<Car> car) {
        if (car.isEmpty()) {
            throw new BusinessException(CarMessages.carNotFound);
        }
    }

    public void carIdShouldBeExist(int carId) {
        Optional<Car> car = carRepository.findById(carId);
        if (car.isEmpty()) {
            throw new BusinessException(CarMessages.carNotFound);
        }
    }

    public void carShouldBeAvailable(int carId) {
        Optional<Car> car = carRepository.findById(carId);
        if (!car.get().getState().equals(CarState.AVAILABLE)) {
            throw new BusinessException(CarMessages.carIsNotAvailable);
        }
    }

    public void plateShouldBeUnique(String plate) {
        Optional<Car> car = carRepository.findByPlate(plate);
        if (car.isPresent()) {
            throw new BusinessException(CarMessages.plateIsAlreadyExist);
        }
    }
}