package com.turkcell.rentACar1.business.rules;

import com.turkcell.rentACar1.business.constants.messages.TransmissionMessages;
import com.turkcell.rentACar1.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentACar1.dataAccess.abstracts.ModelRepository;
import com.turkcell.rentACar1.dataAccess.abstracts.TransmissionRepository;
import com.turkcell.rentACar1.entities.concretes.Model;
import com.turkcell.rentACar1.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@AllArgsConstructor
@Service
public class TransmissionBusinessRules {
    private final TransmissionRepository transmissionRepository;

    public void transmissionShouldBeExist(Optional<Transmission> transmission) {
        if (transmission.isEmpty()) {
            throw new BusinessException(TransmissionMessages.transmissionNotFound);
        }
    }

    public void transmissionIdShouldBeExist(int transmissionId) {
        Optional<Transmission> transmission = transmissionRepository.findById(transmissionId);
        if (transmission.isEmpty()) {
            throw new BusinessException(TransmissionMessages.transmissionNotFound);
        }
    }

    public void transmissionNameCanNotBeDuplicatedWhenInserted(String name) {
        Optional<Transmission> foundOptionalTransmission = transmissionRepository.findByNameIgnoreCase(name.trim());
        if (foundOptionalTransmission.isPresent()) {
            throw new BusinessException(TransmissionMessages.transmissionAlreadyExists);
        }
    }

    public void transmissionNameCanNotBeDuplicatedWhenUpdated(int id, String name) {
        boolean exists = transmissionRepository.existsByNameIgnoreCaseAndIdIsNot(name.trim(), id);
        if (exists) {
            throw new BusinessException(TransmissionMessages.transmissionAlreadyExists);
        }
    }
}