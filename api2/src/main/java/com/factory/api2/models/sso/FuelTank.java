package com.factory.api2.models.sso;

import java.io.Serializable;
import java.time.LocalDateTime;

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
    @UniqueConstraint(columnNames = {"sku", "fuelId", "stationId"})
})
@Data
public class FuelTank implements Serializable {
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(50)")
    private String UniqueId;

    // ký hiệu bồn chứa (bồn A2, bồn C.12)
    @Column(name = "sku", columnDefinition = "varchar(4)", nullable = false)
    private String SKU;
    
    // tối đa bồn chứa
    @Column(name = "maximunLit", columnDefinition = "float", nullable = false)
    private float MaximunLit;

    // bồn chứa còn lại bao nhiêu lít
    @Column(name = "currentLit", columnDefinition = "float", nullable = false)
    private float CurrentLit;

    @Column(name = "createdAt", columnDefinition = "datetime")
    @Temporal(TemporalType.DATE)
    private LocalDateTime CreatedAt = LocalDateTime.now();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fuelId", nullable = false)
    private Fuel fuel;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stationId", nullable = false)
    private Station station;
}
