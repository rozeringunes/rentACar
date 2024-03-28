package com.turkcell.rentACar1.business.rules;

import com.turkcell.rentACar1.business.constants.messages.CorporateCustomerMessages;
import com.turkcell.rentACar1.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentACar1.dataAccess.abstracts.CorporateCustomerRepository;
import com.turkcell.rentACar1.entities.concretes.CorporateCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CorporateCustomerBusinessRules {
    private final CorporateCustomerRepository corporateCustomerRepository;

    public void corporateCustomerShouldBeExist(Optional<CorporateCustomer> corporateCustomer) {
        if (corporateCustomer.isEmpty()) {
            throw new BusinessException(CorporateCustomerMessages.corporateCustomerNotFound);
        }
    }

    public void corporateCustomerIdShouldBeExist(int corporateCustomerId) {
        Optional<CorporateCustomer> corporateCustomer = corporateCustomerRepository.findById(corporateCustomerId);
        if (corporateCustomer.isEmpty()) {
            throw new BusinessException(CorporateCustomerMessages.corporateCustomerNotFound);
        }
    }
}