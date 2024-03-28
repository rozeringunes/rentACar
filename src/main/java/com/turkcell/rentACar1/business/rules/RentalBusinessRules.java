package com.turkcell.rentACar1.business.rules;

import com.turkcell.rentACar1.business.abstracts.CustomerService;
import com.turkcell.rentACar1.business.constants.messages.RentalMessages;
import com.turkcell.rentACar1.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentACar1.dataAccess.abstracts.CarRepository;
import com.turkcell.rentACar1.dataAccess.abstracts.RentalRepository;
import com.turkcell.rentACar1.entities.concretes.Car;
import com.turkcell.rentACar1.entities.concretes.Rental;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RentalBusinessRules {
    private final RentalRepository rentalRepository;
    private final CarRepository carRepository;
    private final CustomerService customerService;

    public void rentalShouldBeExist(Optional<Rental> rental) {
        if (rental.isEmpty()) {
            throw new BusinessException(RentalMessages.rentalNotFound);
        }
    }

    public void rentalIdShouldBeExist(int rentalId) {
        Optional<Rental> rental = rentalRepository.findById(rentalId);
        if (rental.isEmpty()) {
            throw new BusinessException(RentalMessages.rentalNotFound);
        }
    }

    public void customerFindeksScoreShouldBeEnough(int customerId, int carId) {
        Optional<Car> car = carRepository.findById(carId);
        if (car.get().getMinFindeksScore() > customerService.getFindeksScore(customerId)) {
            throw new BusinessException(RentalMessages.customerFindeksScoreIsNotEnough);
        }
    }
}