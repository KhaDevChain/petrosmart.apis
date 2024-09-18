package com.factory.api2.ms.models.sso;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * giá nhiên liệu
 */
@Entity
@Table(name = "fuelprices")
@Data
public class FuelPrice implements Serializable {
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(50)")
    private String UniqueId;

    @Column(name = "createdAt", columnDefinition = "varchar(10)", nullable = false)
    private String CreatedAt;

    @Column(name = "timeAt", columnDefinition = "varchar(10)", nullable = false)
    private String TimeAt;

    @Column(name = "price", columnDefinition = "float", nullable = false)
    private float Price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fuelId")
    private Fuel fuel;
}
