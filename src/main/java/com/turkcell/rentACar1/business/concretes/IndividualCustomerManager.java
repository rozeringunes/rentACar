package com.turkcell.rentACar1.business.concretes;

import com.turkcell.rentACar1.business.abstracts.CustomerService;
import com.turkcell.rentACar1.business.abstracts.IndividualCustomerService;
import com.turkcell.rentACar1.business.dtos.requests.customers.CreateCustomerRequest;
import com.turkcell.rentACar1.business.dtos.requests.individualCustomers.CreateIndividualCustomerRequest;
import com.turkcell.rentACar1.business.dtos.requests.individualCustomers.UpdateIndividualCustomerRequest;
import com.turkcell.rentACar1.business.dtos.responses.customers.CreatedCustomerResponse;
import com.turkcell.rentACar1.business.dtos.responses.individualCustomers.CreatedIndividualCustomerResponse;
import com.turkcell.rentACar1.business.dtos.responses.individualCustomers.GetAllIndividualCustomersListItemDto;
import com.turkcell.rentACar1.business.dtos.responses.individualCustomers.GetIndividualCustomerResponse;
import com.turkcell.rentACar1.business.dtos.responses.individualCustomers.UpdatedIndividualCustomerResponse;
import com.turkcell.rentACar1.business.rules.IndividualCustomerBusinessRules;
import com.turkcell.rentACar1.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentACar1.dataAccess.abstracts.IndividualCustomerRepository;
import com.turkcell.rentACar1.entities.concretes.Customer;
import com.turkcell.rentACar1.entities.concretes.IndividualCustomer;
import com.turkcell.rentACar1.entities.enums.CustomerType;
import lombok.AllArgsConstructor;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class IndividualCustomerManager implements IndividualCustomerService {
    private final IndividualCustomerRepository individualCustomerRepository;
    private final ModelMapperService modelMapperService;
    private final IndividualCustomerBusinessRules individualCustomerBusinessRules;
    private final CustomerService customerService;

    @Override
    public CreatedIndividualCustomerResponse add(CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        CreatedCustomerResponse createdCustomerResponse = customerService.add(new CreateCustomerRequest(CustomerType.INDIVIDUAL));
        Customer customer = modelMapperService.forResponse().map(createdCustomerResponse, Customer.class);

        IndividualCustomer individualCustomer = modelMapperService.forRequest().map(createIndividualCustomerRequest, IndividualCustomer.class);
        individualCustomer.setCreatedDate(LocalDateTime.now());
        individualCustomer.setCustomer(customer);

        IndividualCustomer createdIndividualCustomer = individualCustomerRepository.save(individualCustomer);
        return modelMapperService.forResponse().map(createdIndividualCustomer, CreatedIndividualCustomerResponse.class);
    }

    @Override
    public UpdatedIndividualCustomerResponse update(int id, UpdateIndividualCustomerRequest updateIndividualCustomerRequest) {
        individualCustomerBusinessRules.individualCustomerIdShouldBeExist(id);
        IndividualCustomer individualCustomerToUpdate = modelMapperService.forRequest().map(updateIndividualCustomerRequest, IndividualCustomer.class);
        individualCustomerToUpdate.setId(id);
        IndividualCustomer updatedIndividualCustomer = individualCustomerRepository.save(individualCustomerToUpdate);
        return modelMapperService.forResponse().map(updatedIndividualCustomer, UpdatedIndividualCustomerResponse.class);
    }

    @Override
    public void delete(int id) {
        Optional<IndividualCustomer> foundOptionalIndividualCustomer = individualCustomerRepository.findById(id);
        individualCustomerBusinessRules.individualCustomerShouldBeExist(foundOptionalIndividualCustomer);
        individualCustomerRepository.delete(foundOptionalIndividualCustomer.get());
    }

    @Override
    public List<GetAllIndividualCustomersListItemDto> getAll() {
        List<IndividualCustomer> individualCustomers = individualCustomerRepository.findAll();
        return modelMapperService.forResponse().map(individualCustomers, new TypeToken<List<GetAllIndividualCustomersListItemDto>>() {
        }.getType());
    }

    @Override
    public GetIndividualCustomerResponse get(int id) {
        Optional<IndividualCustomer> foundOptionalIndividualCustomer = individualCustomerRepository.findById(id);
        individualCustomerBusinessRules.individualCustomerShouldBeExist(foundOptionalIndividualCustomer);
        return modelMapperService.forResponse().map(foundOptionalIndividualCustomer.get(), GetIndividualCustomerResponse.class);
    }
}
