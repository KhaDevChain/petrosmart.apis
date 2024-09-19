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
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

/**
 * nhân viên
 */
@Entity
@Table(
    name = "employees",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"sku", "email"})
    }
)
@Data
public class Employee implements Serializable{
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(50)")
    private String UniqueId;

    @Column(name = "sku", columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String SKU;

    @Column(name = "email", columnDefinition = "varchar(70)")
    private String Email;

    @Column(name = "password", columnDefinition = "varchar(255)", nullable = false)
    private String Password;

    @Column(name = "address", columnDefinition = "varchar(100)")
    private String Address;

    @Column(name = "activated", columnDefinition = "boolean")
    private boolean Activated = false;

    @Column(name = "createdAt", columnDefinition = "datetime")
    @Temporal(TemporalType.DATE)
    private Date CreatedAt = new Date();

    // khóa ngoại

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chainId")
    @JsonIgnore
    private Chain chain;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stationId")
    @JsonIgnore
    private Station station;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId")
    private Role role;
}
