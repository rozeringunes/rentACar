package com.turkcell.rentACar1.business.rules;

import com.turkcell.rentACar1.business.constants.messages.IndividualCustomerMessages;
import com.turkcell.rentACar1.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentACar1.dataAccess.abstracts.IndividualCustomerRepository;
import com.turkcell.rentACar1.entities.concretes.IndividualCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


    @Service
    @AllArgsConstructor
    public class IndividualCustomerBusinessRules {
        private final IndividualCustomerRepository individualCustomerRepository;

        public void individualCustomerShouldBeExist(Optional<IndividualCustomer> individualCustomer) {
            if (individualCustomer.isEmpty()) {
                throw new BusinessException(IndividualCustomerMessages.individualCustomerNotFound);
            }
        }

        public void individualCustomerIdShouldBeExist(int individualCustomerId) {
            Optional<IndividualCustomer> individualCustomer = individualCustomerRepository.findById(individualCustomerId);
            if (individualCustomer.isEmpty()) {
                throw new BusinessException(IndividualCustomerMessages.individualCustomerNotFound);
            }
        }
    }

