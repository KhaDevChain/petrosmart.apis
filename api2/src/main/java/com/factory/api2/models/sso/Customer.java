package com.factory.api2.models.sso;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

/**
 * Khách hàng
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

    @Column(name = "customerName", columnDefinition = "varchar(45)", nullable = false)
    private String CustomerName;

    @Column(name = "phone", columnDefinition = "varchar(12)", nullable = false, unique = true)
    private String Phone;

    @Column(name = "address", columnDefinition = "varchar(100)")
    private String Address;

    @Column(name = "tax", columnDefinition = "varchar(10)")
    private String Tax;

    @Column(name = "cccd", columnDefinition = "varchar(12)")
    private String CCCD;

    // account chuyển khoản
    @Column(name = "acNumber", columnDefinition = "varchar(25)")
    private String ACNumber;

    @Column(name = "cardId", columnDefinition = "varchar(50)")
    private String CardId;

    @Column(name = "activated", columnDefinition = "boolean")
    private boolean Activated = false;

    @Column(name = "createdAt", columnDefinition = "datetime")
    private LocalDateTime CreatedAt = LocalDateTime.now();
}
