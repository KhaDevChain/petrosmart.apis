package com.factory.api2.models.sso;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

/**
 * chuỗi xăng
 */
@Entity
@Table(
    name = "chains",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"sku", "chainName"}),
        @UniqueConstraint(columnNames = {"sku", "chainName", "director"}),
    }
)
@Data
public class Chain {
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(50)")
    private String UniqueId;

    @Column(name = "sku", columnDefinition = "varchar(21)", nullable = false, unique = true)
    private String SKU;

    @Column(name = "chainName", columnDefinition = "varchar(30)", nullable = false, unique = true)
    private String ChainName;

    @Column(name = "director", columnDefinition = "varchar(40)")
    private String Director;

    @Column(name = "activated", columnDefinition = "boolean")
    private boolean Activated = false;

    @Column(name = "createdAt", columnDefinition = "datetime")
    private LocalDateTime CreatedAt = LocalDateTime.now();

    // 1 chuỗi sẽ có nhiều trạm
    @OneToMany(mappedBy = "chain")
    List<Station> stations = new ArrayList<Station>();
}
