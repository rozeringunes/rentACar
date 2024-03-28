package com.turkcell.rentACar1.api.controller;

import com.turkcell.rentACar1.business.abstracts.TransmissionService;
import com.turkcell.rentACar1.business.dtos.requests.transmissions.CreateTransmissionRequest;
import com.turkcell.rentACar1.business.dtos.requests.transmissions.UpdateTransmissionRequest;
import com.turkcell.rentACar1.business.dtos.responses.transmissions.CreatedTransmissionResponse;
import com.turkcell.rentACar1.business.dtos.responses.transmissions.GetAllTransmissionsListItemDto;
import com.turkcell.rentACar1.business.dtos.responses.transmissions.GetTransmissionResponse;
import com.turkcell.rentACar1.business.dtos.responses.transmissions.UpdatedTransmissionResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/transmissions")
public class TransmissionsController {
    private TransmissionService  transmissionService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedTransmissionResponse add(@RequestBody  CreateTransmissionRequest createTransmissionRequest){
        return transmissionService.add(createTransmissionRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedTransmissionResponse update(@Valid @PathVariable int id, @RequestBody UpdateTransmissionRequest transmission) {
        return transmissionService.update(id, transmission);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        transmissionService.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetTransmissionResponse get(@PathVariable int id) {
        return transmissionService.get(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllTransmissionsListItemDto> getAll() {
        return transmissionService.getAll();
    }
}