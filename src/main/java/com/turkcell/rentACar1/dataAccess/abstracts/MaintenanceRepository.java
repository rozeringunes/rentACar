package com.turkcell.rentACar1.dataAccess.abstracts;

import com.turkcell.rentACar1.entities.concretes.IndividualCustomer;
import com.turkcell.rentACar1.entities.concretes.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepository  extends JpaRepository<Maintenance, Integer> {
}
