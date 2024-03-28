package com.turkcell.rentACar1.dataAccess.abstracts;

import com.turkcell.rentACar1.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository <Brand,Integer> {
    Optional<Brand> findByNameIgnoreCase(String name);
    boolean existsByNameIgnoreCaseAndIdIsNot(String name, int id);

}
