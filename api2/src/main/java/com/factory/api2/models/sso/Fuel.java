package com.factory.api2.models.sso;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

/**
 * nhiên liệu
 */
@Entity
@Table(name = "fuels", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"sku", "fuelName"})
})
@Data
public class Fuel implements Serializable {
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(50)")
    private String UniqueId;

    @Column(name = "sku", columnDefinition = "varchar(15)", nullable = false, unique = true)
    private String SKU;
    
    @Column(name = "fuelName", columnDefinition = "varchar(20)", unique = true, nullable = false)
    private String FuelName;

    @Column(name = "activated", columnDefinition = "boolean")
    private boolean Activated = false;

    @Column(name = "createdAt", columnDefinition = "datetime")
    private LocalDateTime CreatedAt = LocalDateTime.now();
}