package com.factory.api2.models.sso;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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

    @Column(name = "sku", columnDefinition = "varchar(21)", nullable = false, unique = true)
    private String SKU;

    @Column(name = "email", columnDefinition = "varchar(35)", nullable = false, unique = true)
    private String Email;

    @Column(name = "fullName", columnDefinition = "varchar(50)", nullable = false)
    private String FullName;

    @Column(name = "password", columnDefinition = "varchar(256)", nullable = false)
    private String Password;

    @Column(name = "address", columnDefinition = "varchar(120)")
    private String Address;

    @Column(name = "activated", columnDefinition = "boolean")
    private boolean Activated = false;

    @Column(name = "createdAt", columnDefinition = "datetime")
    private LocalDateTime CreatedAt = LocalDateTime.now();

    // khóa ngoại

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chainId", nullable = false)
    @JsonIgnore
    private Chain chain;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stationId", nullable = false)
    @JsonIgnore
    private Station station;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId", nullable = false)
    private Role role;
}
