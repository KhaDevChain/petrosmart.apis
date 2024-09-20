package com.factory.api2.models.sso;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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

    @Column(name = "price", columnDefinition = "float", nullable = false)
    private float Price;

    @Column(name = "createdAt")
    @Temporal(TemporalType.DATE)
    private Date CreatedAt = new Date();

    @Column(name = "timeAt", columnDefinition = "varchar(10)")
    private String TimeAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fuelId")
    private Fuel fuel;
}
