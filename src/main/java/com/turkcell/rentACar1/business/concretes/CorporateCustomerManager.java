package com.turkcell.rentACar1.business.concretes;

import com.turkcell.rentACar1.business.abstracts.CorporateCustomerService;
import com.turkcell.rentACar1.business.abstracts.CustomerService;
import com.turkcell.rentACar1.business.dtos.requests.corporateCustomers.CreateCorporateCustomerRequest;
import com.turkcell.rentACar1.business.dtos.requests.corporateCustomers.UpdateCorporateCustomerRequest;
import com.turkcell.rentACar1.business.dtos.requests.customers.CreateCustomerRequest;
import com.turkcell.rentACar1.business.dtos.responses.corporateCustomers.CreatedCorporateCustomerResponse;
import com.turkcell.rentACar1.business.dtos.responses.corporateCustomers.GetAllCorporateCustomersListItemDto;
import com.turkcell.rentACar1.business.dtos.responses.corporateCustomers.GetCorporateCustomerResponse;
import com.turkcell.rentACar1.business.dtos.responses.corporateCustomers.UpdatedCorporateCustomerResponse;
import com.turkcell.rentACar1.business.dtos.responses.customers.CreatedCustomerResponse;
import com.turkcell.rentACar1.business.rules.CorporateCustomerBusinessRules;
import com.turkcell.rentACar1.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentACar1.dataAccess.abstracts.CorporateCustomerRepository;
import com.turkcell.rentACar1.entities.concretes.CorporateCustomer;
import com.turkcell.rentACar1.entities.concretes.Customer;
import com.turkcell.rentACar1.entities.enums.CustomerType;
import lombok.AllArgsConstructor;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CorporateCustomerManager implements CorporateCustomerService {
    private final CorporateCustomerRepository corporateCustomerRepository;
    private final ModelMapperService modelMapperService;
    private final CorporateCustomerBusinessRules corporateCustomerBusinessRules;
    private final CustomerService customerService;

    @Override
    public CreatedCorporateCustomerResponse add(CreateCorporateCustomerRequest createCorporateCustomerRequest) {
        CreatedCustomerResponse createdCustomerResponse = customerService.add(new CreateCustomerRequest(CustomerType.CORPORATE));
        Customer customer = modelMapperService.forResponse().map(createdCustomerResponse, Customer.class);

        CorporateCustomer corporateCustomer = modelMapperService.forRequest().map(createCorporateCustomerRequest, CorporateCustomer.class);
        corporateCustomer.setCreatedDate(LocalDateTime.now());
        corporateCustomer.setCustomer(customer);

        CorporateCustomer createdCorporateCustomer = corporateCustomerRepository.save(corporateCustomer);
        return modelMapperService.forResponse().map(createdCorporateCustomer, CreatedCorporateCustomerResponse.class);
    }

    @Override
    public UpdatedCorporateCustomerResponse update(int id, UpdateCorporateCustomerRequest updateCorporateCustomerRequest) {
        corporateCustomerBusinessRules.corporateCustomerIdShouldBeExist(id);
        CorporateCustomer corporateCustomerToUpdate = modelMapperService.forRequest().map(updateCorporateCustomerRequest, CorporateCustomer.class);
        corporateCustomerToUpdate.setId(id);
        CorporateCustomer updatedCorporateCustomer = corporateCustomerRepository.save(corporateCustomerToUpdate);
        return modelMapperService.forResponse().map(updatedCorporateCustomer, UpdatedCorporateCustomerResponse.class);
    }

    @Override
    public void delete(int id) {
        Optional<CorporateCustomer> foundOptionalCorporateCustomer = corporateCustomerRepository.findById(id);
        corporateCustomerBusinessRules.corporateCustomerShouldBeExist(foundOptionalCorporateCustomer);
        corporateCustomerRepository.delete(foundOptionalCorporateCustomer.get());
    }

    @Override
    public List<GetAllCorporateCustomersListItemDto> getAll() {
        List<CorporateCustomer> corporateCustomers = corporateCustomerRepository.findAll();
        return modelMapperService.forResponse().map(corporateCustomers, new TypeToken<List<GetAllCorporateCustomersListItemDto>>() {
        }.getType());
    }

    @Override
    public GetCorporateCustomerResponse get(int id) {
        Optional<CorporateCustomer> foundOptionalCorporateCustomer = corporateCustomerRepository.findById(id);
        corporateCustomerBusinessRules.corporateCustomerShouldBeExist(foundOptionalCorporateCustomer);
        return modelMapperService.forResponse().map(foundOptionalCorporateCustomer.get(), GetCorporateCustomerResponse.class);
    }
}