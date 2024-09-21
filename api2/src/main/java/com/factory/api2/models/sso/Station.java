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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

/**
 * trạm
 */
@Entity
@Table(name = "stations", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"stationName", "tax", "sku"}),
    @UniqueConstraint(columnNames = {"stationName", "tax"})
})
@Data
public class Station implements Serializable {
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(50)")
    private String UniqueId;

    @Column(name = "sku", columnDefinition = "varchar(15)", nullable = false, unique = true)
    private String SKU;

    @Column(name = "stationName", columnDefinition = "varchar(30)", unique = true, nullable = false)
    private String StationName;

    @Column(name = "address", columnDefinition = "varchar(120)", nullable = false)
    private String Address;

    @Column(name = "hotline", columnDefinition = "varchar(13)")
    private String Hotline;

    @Column(name = "tax", columnDefinition = "varchar(10)", nullable = false)
    private String Tax;

    // đối tác cung cấp hóa đơn điện tử là ai
    @Column(name = "partnerEInvoiceId", columnDefinition = "varchar(50)")
    private String PartnerEInvoiceId;

    @Column(name = "activated", columnDefinition = "boolean")
    private boolean Activated = false;

    @Column(name = "createdAt", columnDefinition = "datetime")
    @Temporal(TemporalType.DATE)
    private LocalDateTime CreatedAt = LocalDateTime.now();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chainId", nullable = false)
    @JsonIgnore
    private Chain chain;
}
