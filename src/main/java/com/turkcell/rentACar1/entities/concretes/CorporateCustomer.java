package com.turkcell.rentACar1.entities.concretes;

import com.turkcell.rentACar1.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "corporate_customers")
public class CorporateCustomer extends BaseEntity {

    @Column(name="company=name")
    private String companyName;

    @Column(name="tax=no")
    private String taxNo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;



}
