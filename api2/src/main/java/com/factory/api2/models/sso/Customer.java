package com.factory.api2.models.sso;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

/**
 * chuỗi xăng
 */
@Entity
@Table(
    name = "customers",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"sku", "customerName"}),
        @UniqueConstraint(columnNames = {"sku", "customerName", "phone"}),
    }
)
@Data
public class Customer {
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(50)")
    private String UniqueId;

    @Column(name = "sku", columnDefinition = "varchar(21)", nullable = false, unique = true)
    private String SKU;

    @Column(name = "customerName", columnDefinition = "varchar(45)", nullable = false, unique = true)
    private String CustomerName;

    @Column(name = "phone", columnDefinition = "varchar(12)", nullable = false, unique = true)
    private String Phone;

    @Column(name = "address", columnDefinition = "varchar(100)")
    private String Address;

    @Column(name = "tax", columnDefinition = "varchar(10)")
    private String Tax;

    @Column(name = "cardId", columnDefinition = "varchar(50)")
    private String CardId;

    @Column(name = "activated", columnDefinition = "boolean")
    private boolean Activated = false;

    @Column(name = "createdAt", columnDefinition = "datetime")
    @Temporal(TemporalType.DATE)
    private Date CreatedAt = new Date();
}
