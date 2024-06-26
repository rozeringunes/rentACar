package com.turkcell.rentACar1.entities.concretes;

import com.turkcell.rentACar1.core.entities.BaseEntity;
import com.turkcell.rentACar1.entities.enums.CustomerType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="customers")
public class Customer extends BaseEntity{
    @Column(name = "type")
    private CustomerType type;

    @Column(name="findeks_score")
    private int findeksScore;


    @OneToOne(mappedBy = "customer")
    private CorporateCustomer corporateCustomer;

    @OneToOne(mappedBy = "customer")
    private IndividualCustomer individualCustomer;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Rental> rentals;
}