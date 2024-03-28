package com.turkcell.rentACar1.business.abstracts;

import com.turkcell.rentACar1.business.dtos.requests.corporateCustomers.CreateCorporateCustomerRequest;
import com.turkcell.rentACar1.business.dtos.requests.corporateCustomers.UpdateCorporateCustomerRequest;
import com.turkcell.rentACar1.business.dtos.responses.corporateCustomers.CreatedCorporateCustomerResponse;
import com.turkcell.rentACar1.business.dtos.responses.corporateCustomers.GetAllCorporateCustomersListItemDto;
import com.turkcell.rentACar1.business.dtos.responses.corporateCustomers.GetCorporateCustomerResponse;
import com.turkcell.rentACar1.business.dtos.responses.corporateCustomers.UpdatedCorporateCustomerResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface CorporateCustomerService {
    CreatedCorporateCustomerResponse add(CreateCorporateCustomerRequest createCorporateCustomerRequest);
    UpdatedCorporateCustomerResponse update(int id, @Valid UpdateCorporateCustomerRequest createCorporateCustomerRequest);
    void delete (int id);
    List<GetAllCorporateCustomersListItemDto>getAll();
    GetCorporateCustomerResponse get (int id);}
