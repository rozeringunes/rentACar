package com.turkcell.rentACar1.dataAccess.abstracts;

import com.turkcell.rentACar1.entities.concretes.Fuel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuelRepository extends JpaRepository<Fuel,Integer>{
    Optional<Fuel> findByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCaseAndIdIsNot(String name, int id);
}
