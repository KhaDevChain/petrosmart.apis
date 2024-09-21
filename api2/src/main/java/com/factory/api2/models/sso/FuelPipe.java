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

    // vòi bơm số mấy
    @Column(name = "indexPipe", columnDefinition = "varchar(2)", nullable = false)
    private String IndexPipe;

    @Column(name = "createdAt", columnDefinition = "datetime")
    @Temporal(TemporalType.DATE)
    private Date CreatedAt = new Date();

    @Column(name = "activated", columnDefinition = "boolean")
    private boolean Activated = false;

    // phương thức xuất hóa đơn
    @Column(name = "method", columnDefinition = "varchar(5)", nullable = false)
    private String MethodExport;

    @Column(name = "fuelName", columnDefinition = "varchar(20)", nullable = false)
    private String FuelName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fuelTankId", nullable = false)
    @JsonIgnore
    private FuelTank fuelTank;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fuelRectangularId", nullable = false)
    @JsonIgnore
    private FuelRectangular fuelRectangular;
}
