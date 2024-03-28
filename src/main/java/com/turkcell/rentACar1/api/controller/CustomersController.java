package com.turkcell.rentACar1.api.controller;

import com.turkcell.rentACar1.business.abstracts.CustomerService;
import com.turkcell.rentACar1.business.dtos.responses.customers.GetAllCustomersListItemDto;
import com.turkcell.rentACar1.business.dtos.responses.customers.GetCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/customers")
public class CustomersController {
    private CustomerService customerService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private GetCustomerResponse get(@PathVariable int id){
        return customerService.get(id);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllCustomersListItemDto> getAll() {
        return customerService.getAll();
    }
}
