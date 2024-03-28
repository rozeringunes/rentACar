package com.turkcell.rentACar1.business.abstracts;

import com.turkcell.rentACar1.business.dtos.requests.individualCustomers.CreateIndividualCustomerRequest;
import com.turkcell.rentACar1.business.dtos.requests.individualCustomers.UpdateIndividualCustomerRequest;
import com.turkcell.rentACar1.business.dtos.responses.individualCustomers.CreatedIndividualCustomerResponse;
import com.turkcell.rentACar1.business.dtos.responses.individualCustomers.GetAllIndividualCustomersListItemDto;
import com.turkcell.rentACar1.business.dtos.responses.individualCustomers.GetIndividualCustomerResponse;
import com.turkcell.rentACar1.business.dtos.responses.individualCustomers.UpdatedIndividualCustomerResponse;

import java.util.List;

public interface IndividualCustomerService {
    CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest);

    UpdatedIndividualCustomerResponse update(int id, UpdateIndividualCustomerRequest updateIndividualCustomerRequest);

    void delete(int id);

    List<GetAllIndividualCustomersListItemDto> getAll();

    GetIndividualCustomerResponse get(int id);
}
