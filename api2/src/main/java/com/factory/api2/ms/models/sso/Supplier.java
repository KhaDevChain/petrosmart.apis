package com.factory.api2.ms.models.sso;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
        @UniqueConstraint(columnNames = {"sku", "supplierName"}),
        @UniqueConstraint(columnNames = {"sku", "supplierName", "director"}),
    }
)
@Data
public class Supplier {
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(50)")
    private String UniqueId;

    @Column(name = "sku", columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String SKU;

    @Column(name = "supplierName", columnDefinition = "varchar(70)", nullable = false, unique = true)
    private String SupplierName;

    @Column(name = "director", columnDefinition = "varchar(70)")
    private String Director;

    @Column(name = "createdAt", columnDefinition = "datetime")
    @Temporal(TemporalType.DATE)
    private Date CreatedAt = new Date();

    // 1 chuỗi sẽ có nhiều trạm
    @OneToMany(mappedBy = "supplier")
    List<Station> employees = new ArrayList<Station>();
}
