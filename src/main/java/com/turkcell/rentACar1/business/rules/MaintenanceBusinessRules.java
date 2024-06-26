package com.turkcell.rentACar1.business.rules;

import com.turkcell.rentACar1.business.constants.messages.MaintenanceMessages;
import com.turkcell.rentACar1.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentACar1.dataAccess.abstracts.MaintenanceRepository;
import com.turkcell.rentACar1.entities.concretes.Maintenance;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MaintenanceBusinessRules {
    private final MaintenanceRepository maintenanceRepository;

    public void maintenanceShouldBeExist(Optional<Maintenance> maintenance) {
        if (maintenance.isEmpty()) {
            throw new BusinessException(MaintenanceMessages.maintenanceNotFound);
        }
    }

    public void maintenanceIdShouldBeExist(int maintenanceId) {
        Optional<Maintenance> maintenance = maintenanceRepository.findById(maintenanceId);
        if (maintenance.isEmpty()) {
            throw new BusinessException(MaintenanceMessages.maintenanceNotFound);
        }
    }
}