package com.factory.api2.ms.models.sso;

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
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

/**
 * trạm
 */
@Entity
@Table(name = "stations", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"stationName", "tax"}),
    @UniqueConstraint(columnNames = {"stationName", "tax", "address"})
})
@Data
public class Station implements Serializable {
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(50)")
    private String UniqueId;

    @Column(name = "stationName", columnDefinition = "varchar(70)", unique = true, nullable = false)
    private String StationName;

    @Column(name = "address", columnDefinition = "varchar(255)", nullable = false)
    private String Address;

    @Column(name = "hotline", columnDefinition = "varchar(15)")
    private String Hotline;

    @Column(name = "tax", columnDefinition = "varchar(10)", nullable = false)
    private String Tax;

    @Column(name = "containNumber", columnDefinition = "int(2)", nullable = false)
    private int ContainNumber;

    @Column(name = "pumpNumber", columnDefinition = "int(2)", nullable = false)
    private int PumpNumber;

    @Column(name = "activated", columnDefinition = "boolean")
    private boolean Activated = false;

    @Column(name = "createdAt", columnDefinition = "datetime")
    @Temporal(TemporalType.DATE)
    private Date CreatedAt = new Date();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chainId")
    @JsonIgnore
    private Chain chain;
}
