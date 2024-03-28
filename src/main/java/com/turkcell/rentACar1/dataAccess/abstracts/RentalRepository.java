package com.turkcell.rentACar1.dataAccess.abstracts;

import com.turkcell.rentACar1.entities.concretes.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental,Integer> {
}
