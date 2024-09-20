package com.factory.api2.models.sso;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

/**
 * nhiên liệu
 */
@Entity
@Table(name = "fuels")
@Data
public class Fuel implements Serializable {
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(50)")
    private String UniqueId;
    
    @Column(name = "fuelName", columnDefinition = "varchar(50)", unique = true, nullable = false)
    private String FuelName;

    @Column(name = "activated", columnDefinition = "boolean")
    private boolean Activated = false;

    @Column(name = "createdAt", columnDefinition = "datetime")
    @Temporal(TemporalType.DATE)
    private Date CreatedAt = new Date();
}