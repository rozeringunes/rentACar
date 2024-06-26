package com.turkcell.rentACar1.business.rules;

import com.turkcell.rentACar1.business.constants.messages.FuelMessages;
import com.turkcell.rentACar1.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentACar1.dataAccess.abstracts.FuelRepository;
import com.turkcell.rentACar1.entities.concretes.Fuel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class FuelBusinessRules {
    private final FuelRepository fuelRepository;

    public void fuelShouldBeExist(Optional<Fuel> fuel) {
        if (fuel.isEmpty()) {
            throw new BusinessException(FuelMessages.fuelNotFound);
        }
    }

    public void fuelIdShouldBeExist(int fuelId) {
        Optional<Fuel> fuel = fuelRepository.findById(fuelId);
        if (fuel.isEmpty()) {
            throw new BusinessException(FuelMessages.fuelNotFound);
        }
    }

    public void fuelNameCanNotBeDuplicatedWhenInserted(String name) {
        Optional<Fuel> foundOptionalFuel = fuelRepository.findByNameIgnoreCase(name.trim());
        if (foundOptionalFuel.isPresent()) {
            throw new BusinessException(FuelMessages.fuelAlreadyExists);
        }
    }

    public void fuelNameCanNotBeDuplicatedWhenUpdated(int id, String name) {
        boolean exists = fuelRepository.existsByNameIgnoreCaseAndIdIsNot(name.trim(), id);
        if (exists) {
            throw new BusinessException(FuelMessages.fuelAlreadyExists);
        }
    }
}