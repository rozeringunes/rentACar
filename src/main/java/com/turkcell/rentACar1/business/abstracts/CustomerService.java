package com.turkcell.rentACar1.business.abstracts;

import com.turkcell.rentACar1.business.dtos.requests.customers.CreateCustomerRequest;
import com.turkcell.rentACar1.business.dtos.responses.customers.CreatedCustomerResponse;
import com.turkcell.rentACar1.business.dtos.responses.customers.GetAllCustomersListItemDto;
import com.turkcell.rentACar1.business.dtos.responses.customers.GetCustomerResponse;

import java.util.List;

public interface CustomerService {
    CreatedCustomerResponse add(CreateCustomerRequest createCustomerRequest);
    List<GetAllCustomersListItemDto>getAll();
    GetCustomerResponse get (int id);
    int getFindeksScore(int customerId);
}
