package com.factory.api2.models.operation;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Table(
    name = "orders", 
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"stationId", "fuelPipeId", "createdAt"})
})
@Data
public class Order implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UniqueId;

    @Column(name = "createdAt", columnDefinition = "datetime")
    @Temporal(TemporalType.DATE)
    private LocalDateTime CreatedAt = LocalDateTime.now();

    // update này là cho update phương thức thanh toán, đánh dấu khách hàng
    @Column(name = "updatedAt", columnDefinition = "datetime")
    @Temporal(TemporalType.DATE)
    private LocalDateTime UpdatedAt = LocalDateTime.now();

    // giao dịch của trạm nào
    @Column(name = "stationId", columnDefinition = "varchar(50)", nullable = false)
    private String StationId;

    // tên của trạm
    @Column(name = "stationName", columnDefinition = "varchar(30)", nullable = false)
    private String StationName;

    // giao dịch của vòi nào
    @Column(name = "fuelPipeId", columnDefinition = "varchar(50)", nullable = false)
    private String FuelPipeId;

    // vòi đó là vòi số mấy
    @Column(name = "indexPipe", columnDefinition = "varchar(2)", nullable = false)
    private String IndexPipe;

    @Column(name = "fuelName", columnDefinition = "varchar(20)", nullable = false)
    private String FuelName;

    @Column(name = "lit", columnDefinition = "float", nullable = false)
    private float Lit;

    // chỉ lấy giá trước thuế
    @Column(name = "price", columnDefinition = "float", nullable = false)
    private float Price;

    @Column(name = "methodPay", columnDefinition = "varchar(25)", nullable = false)
    private String MethodPay = "Tiền mặt";

    @Column(name = "customerId", columnDefinition = "varchar(50)")
    private String CustomerId;

    @Column(name = "customerCardId", columnDefinition = "varchar(25)")
    private String CustomerCardId;

    @Column(name = "customerTax", columnDefinition = "varchar(10)")
    private String CustomerTax;

    @Column(name = "customerName", columnDefinition = "varchar(45)")
    private String CustomerName;

    @Column(name = "idNumRef", columnDefinition = "int(4)")
    private int IdNumRef;

    // số hóa đơn
    @Column(name = "billNo", columnDefinition = "varchar(20)")
    private String BillNo;

    @Column(name = "isExported", columnDefinition = "boolean")
    private boolean IsExported = false;

    @Column(name = "exportedAt", columnDefinition = "datetime")
    @Temporal(TemporalType.DATE)
    private LocalDateTime ExportedAt = LocalDateTime.now();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transactionId", nullable = true) // chưa xuất thì true
    @JsonIgnore
    private Transaction transaction;
}
