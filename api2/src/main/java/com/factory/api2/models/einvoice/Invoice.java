package com.factory.api2.models.einvoice;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "invoices")
@Data
public class Invoice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UniqueId;

    @Column(name = "customerName", columnDefinition = "varchar(45)")
    private String CustomerName;

    @Column(name = "companyName", columnDefinition = "varchar(100)", nullable = false)
    private String CompanyName;

    @Column(name = "taxCode", columnDefinition = "varchar(10)")
    private String TaxCode;

    @Column(name = "cccd", columnDefinition = "varchar(12)")
    private String CCCD;

    @Column(name = "address", columnDefinition = "varchar(100)")
    private String Address;

    @Column(name = "methodPay", columnDefinition = "varchar(25)", nullable = false)
    private String MethodPay = "Tiền mặt";

    @Column(name = "acNumber", columnDefinition = "varchar(25)")
    private String ACNumber;

    // số hóa đơn (chỉ 1)
    @Column(name = "billNo", columnDefinition = "varchar(20)", nullable = false)
    private String BillNo;

    @Column(name = "searchCode", columnDefinition = "varchar(40)")
    private String SearchCode;

    @Column(name = "taxAuthorityCode", columnDefinition = "varchar(40)")
    private String TaxAuthorityCode;

    @Column(name = "note", columnDefinition = "varchar(70)")
    private String Note;

    @Column(name = "createdAt", columnDefinition = "datetime")
    private LocalDateTime CreatedAt = LocalDateTime.now();

    @Column(name = "updatedAt", columnDefinition = "datetime")
    private LocalDateTime UpdatedAt = LocalDateTime.now();

    @Column(name = "transactionId", nullable = false)
    private Long TransactionId;
}
