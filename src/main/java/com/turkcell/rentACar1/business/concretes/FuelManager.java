package com.turkcell.rentACar1.business.concretes;

import com.turkcell.rentACar1.business.abstracts.FuelService;
import com.turkcell.rentACar1.business.dtos.requests.fuels.CreateFuelRequest;
import com.turkcell.rentACar1.business.dtos.requests.fuels.UpdateFuelRequest;
import com.turkcell.rentACar1.business.dtos.responses.fuels.CreatedFuelResponse;
import com.turkcell.rentACar1.business.dtos.responses.fuels.GetAllFuelsListItemDto;
import com.turkcell.rentACar1.business.dtos.responses.fuels.GetFuelResponse;
import com.turkcell.rentACar1.business.dtos.responses.fuels.UpdatedFuelResponse;
import com.turkcell.rentACar1.business.rules.FuelBusinessRules;
import com.turkcell.rentACar1.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentACar1.dataAccess.abstracts.FuelRepository;
import com.turkcell.rentACar1.entities.concretes.Fuel;
import lombok.AllArgsConstructor;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class FuelManager implements FuelService {
    private final FuelRepository fuelRepository;
    private final ModelMapperService modelMapperService;
    private final FuelBusinessRules fuelBusinessRules;

    @Override
    public CreatedFuelResponse add(CreateFuelRequest createFuelRequest) {
        fuelBusinessRules.fuelNameCanNotBeDuplicatedWhenInserted(createFuelRequest.getName());

        Fuel fuel = modelMapperService.forRequest().map(createFuelRequest, Fuel.class);
        fuel.setCreatedDate(LocalDateTime.now());

        Fuel createdFuel = fuelRepository.save(fuel);
        return modelMapperService.forResponse().map(createdFuel, CreatedFuelResponse.class);
    }

    @Override
    public UpdatedFuelResponse update(int id, UpdateFuelRequest updateFuelRequest) {
        fuelBusinessRules.fuelIdShouldBeExist(id);
        fuelBusinessRules.fuelNameCanNotBeDuplicatedWhenUpdated(id, updateFuelRequest.getName());
        Fuel fuelToUpdate = modelMapperService.forRequest().map(updateFuelRequest, Fuel.class);
        fuelToUpdate.setId(id);
        Fuel updatedFuel = fuelRepository.save(fuelToUpdate);
        return modelMapperService.forResponse().map(updatedFuel, UpdatedFuelResponse.class);
    }

    @Override
    public void delete(int id) {
        Optional<Fuel> foundOptionalFuel = fuelRepository.findById(id);
        fuelBusinessRules.fuelShouldBeExist(foundOptionalFuel);
        fuelRepository.delete(foundOptionalFuel.get());
    }

    @Override
    public List<GetAllFuelsListItemDto> getAll() {
        List<Fuel> fuels = fuelRepository.findAll();
        return modelMapperService.forResponse().map(fuels, new TypeToken<List<GetAllFuelsListItemDto>>() {
        }.getType());
    }

    @Override
    public GetFuelResponse get(int id) {
        Optional<Fuel> foundOptionalFuel = fuelRepository.findById(id);
        fuelBusinessRules.fuelShouldBeExist(foundOptionalFuel);
        return modelMapperService.forResponse().map(foundOptionalFuel.get(), GetFuelResponse.class);
    }
}