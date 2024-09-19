package com.factory.api2.ms.models.sso;

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
    name = "suppliers",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"sku", "supplierName"})
    }
)
@Data
public class Supplier {
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(50)")
    private String UniqueId;

    @Column(name = "sku", columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String SKU;

    @Column(name = "supplierName", columnDefinition = "varchar(150)", nullable = false)
    private String SupplierName;

    @Column(name = "phone", columnDefinition = "varchar(15)")
    private String Phone;

    @Column(name = "email", columnDefinition = "varchar(70)")
    private String Email;

    // data dạng list <fuelId,fuelName>;<fuelId,fuelName>
    @Column(name = "fuels", columnDefinition = "varchar(255)")
    private String FuelsList;

    @Column(name = "createdAt", columnDefinition = "datetime")
    @Temporal(TemporalType.DATE)
    private Date CreatedAt = new Date();

    @Column(name = "activated", columnDefinition = "boolean")
    private boolean Activated = false;
}
