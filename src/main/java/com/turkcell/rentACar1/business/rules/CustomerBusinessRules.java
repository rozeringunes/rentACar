package com.turkcell.rentACar1.business.rules;

import com.turkcell.rentACar1.business.constants.messages.CustomerMessages;
import com.turkcell.rentACar1.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentACar1.dataAccess.abstracts.CustomerRepository;
import com.turkcell.rentACar1.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerBusinessRules {
    private final CustomerRepository customerRepository;

    public void customerShouldBeExist(Optional<Customer> customer) {
        if (customer.isEmpty()) {
            throw new BusinessException(CustomerMessages.customerNotFound);
        }
    }
}