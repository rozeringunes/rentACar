package com.turkcell.rentACar1.dataAccess.abstracts;

import com.turkcell.rentACar1.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
