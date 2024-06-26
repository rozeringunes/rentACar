package com.turkcell.rentACar1.entities.concretes;

import com.turkcell.rentACar1.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="maintenances")
public class Maintenance extends BaseEntity {
    @Column(name="sent_date")
    private LocalDateTime sentDate;

    @Column(name="expected_return_date")
    private LocalDateTime expectedReturnDate;

    @Column(name="actual_return_date")
    private LocalDateTime actualReturnDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="car_id")
    private Car car;

}
