package com.factory.api2.ms.models.sso;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * vòi xăng
 */
@Entity
@Table(name = "fuelpipes")
@Data
public class FuelPipe implements Serializable {
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(50)")
    private String UniqueId;

    @Column(name = "indexPipe", columnDefinition = "varchar(2)", nullable = false)
    private String IndexPipe;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fuelTankId")
    @JsonIgnore
    private FuelTank fuelTank;
}
