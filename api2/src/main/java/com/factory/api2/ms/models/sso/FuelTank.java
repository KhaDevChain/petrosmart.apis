package com.factory.api2.ms.models.sso;

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
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

/**
 * bồn xăng
 */
@Entity
@Table(name = "fueltanks", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"indexTank", "fuelId", "stationId"})
})
@Data
public class FuelTank implements Serializable {
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(50)")
    private String UniqueId;

    @Column(name = "indexTank", columnDefinition = "varchar(3)", nullable = false)
    private String IndexTank;
    
    @Column(name = "maximunLit", columnDefinition = "float", nullable = false)
    private float MaximunLit;

    @Column(name = "currentLit", columnDefinition = "float", nullable = false)
    private float CurrentLit;

    @Column(name = "createdAt", columnDefinition = "datetime")
    @Temporal(TemporalType.DATE)
    private Date CreatedAt = new Date();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fuelId")
    private Fuel fuel;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stationId")
    private Station station;
}
