package com.turkcell.rentACar1.business.concretes;

import com.turkcell.rentACar1.business.abstracts.CarService;
import com.turkcell.rentACar1.business.abstracts.RentalService;
import com.turkcell.rentACar1.business.dtos.requests.rentals.CreateRentalRequest;
import com.turkcell.rentACar1.business.dtos.requests.rentals.UpdateRentalRequest;
import com.turkcell.rentACar1.business.dtos.responses.rentals.CreatedRentalResponse;
import com.turkcell.rentACar1.business.dtos.responses.rentals.GetAllRentalsListItemDto;
import com.turkcell.rentACar1.business.dtos.responses.rentals.GetRentalResponse;
import com.turkcell.rentACar1.business.dtos.responses.rentals.UpdatedRentalResponse;
import com.turkcell.rentACar1.business.rules.CarBusinessRules;
import com.turkcell.rentACar1.business.rules.RentalBusinessRules;
import com.turkcell.rentACar1.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentACar1.dataAccess.abstracts.RentalRepository;
import com.turkcell.rentACar1.entities.concretes.Rental;
import com.turkcell.rentACar1.entities.enums.CarState;
import lombok.AllArgsConstructor;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RentalManager implements RentalService {
    private final RentalRepository rentalRepository;
    private final ModelMapperService modelMapperService;
    private final RentalBusinessRules rentalBusinessRules;
    private final CarBusinessRules carBusinessRules;
    private final CarService carService;

    @Override
    public CreatedRentalResponse add(CreateRentalRequest createRentalRequest) {
        carBusinessRules.carIdShouldBeExist(createRentalRequest.getCarId());
        carBusinessRules.carShouldBeAvailable(createRentalRequest.getCarId());
        rentalBusinessRules.customerFindeksScoreShouldBeEnough(createRentalRequest.getCustomerId(), createRentalRequest.getCarId());
        Rental rental = modelMapperService.forRequest().map(createRentalRequest, Rental.class);
        rental.setCreatedDate(LocalDateTime.now());

        carService.updateState(createRentalRequest.getCarId(), CarState.RENTED);

        Rental createdRental = rentalRepository.save(rental);
        return modelMapperService.forResponse().map(createdRental, CreatedRentalResponse.class);
    }

    @Override
    public UpdatedRentalResponse update(int id, UpdateRentalRequest updateRentalRequest) {
        rentalBusinessRules.rentalIdShouldBeExist(id);
        Rental rentalToUpdate = modelMapperService.forRequest().map(updateRentalRequest, Rental.class);
        rentalToUpdate.setId(id);
        Rental updatedRental = rentalRepository.save(rentalToUpdate);
        return modelMapperService.forResponse().map(updatedRental, UpdatedRentalResponse.class);
    }

    @Override
    public void delete(int id) {
        Optional<Rental> foundOptionalRental = rentalRepository.findById(id);
        rentalBusinessRules.rentalShouldBeExist(foundOptionalRental);
        rentalRepository.delete(foundOptionalRental.get());
    }

    @Override
    public List<GetAllRentalsListItemDto> getAll() {
        List<Rental> rentals = rentalRepository.findAll();
        return modelMapperService.forResponse().map(rentals, new TypeToken<List<GetAllRentalsListItemDto>>() {
        }.getType());
    }

    @Override
    public GetRentalResponse get(int id) {
        Optional<Rental> foundOptionalRental = rentalRepository.findById(id);
        rentalBusinessRules.rentalShouldBeExist(foundOptionalRental);
        return modelMapperService.forResponse().map(foundOptionalRental.get(), GetRentalResponse.class);
    }
}