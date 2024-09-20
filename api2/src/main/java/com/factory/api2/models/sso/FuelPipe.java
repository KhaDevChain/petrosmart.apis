package com.factory.api2.models.sso;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Column(name = "createdAt", columnDefinition = "datetime")
    @Temporal(TemporalType.DATE)
    private Date CreatedAt = new Date();

    @Column(name = "activated", columnDefinition = "boolean")
    private boolean Activated = false;

    @Column(name = "method", columnDefinition = "varchar(5)", nullable = false)
    private String methodExport;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fuelTankId")
    @JsonIgnore
    private FuelTank fuelTank;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fuelRectangularId")
    @JsonIgnore
    private FuelRectangular fuelRectangular;
}
