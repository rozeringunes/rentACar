package com.turkcell.rentACar1.api.controller;

import com.turkcell.rentACar1.business.abstracts.IndividualCustomerService;
import com.turkcell.rentACar1.business.dtos.requests.individualCustomers.CreateIndividualCustomerRequest;
import com.turkcell.rentACar1.business.dtos.requests.individualCustomers.UpdateIndividualCustomerRequest;
import com.turkcell.rentACar1.business.dtos.responses.individualCustomers.CreatedIndividualCustomerResponse;
import com.turkcell.rentACar1.business.dtos.responses.individualCustomers.GetAllIndividualCustomersListItemDto;
import com.turkcell.rentACar1.business.dtos.responses.individualCustomers.GetIndividualCustomerResponse;
import com.turkcell.rentACar1.business.dtos.responses.individualCustomers.UpdatedIndividualCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/individual-customers")
public class IndividualCustomersController {
    private IndividualCustomerService individualCustomerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedIndividualCustomerResponse add(@Valid @RequestBody CreateIndividualCustomerRequest createIndividualCustomerRequest) {
        return individualCustomerService.add(createIndividualCustomerRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedIndividualCustomerResponse update(@PathVariable int id, @Valid @RequestBody UpdateIndividualCustomerRequest individualCustomer) {
        return individualCustomerService.update(id, individualCustomer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        individualCustomerService.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetIndividualCustomerResponse get(@PathVariable int id) {
        return individualCustomerService.get(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllIndividualCustomersListItemDto> getAll() {
        return individualCustomerService.getAll();
    }
}