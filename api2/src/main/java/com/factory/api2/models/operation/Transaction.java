package com.factory.api2.models.operation;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Table(name = "transactions", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"billNo", "exportedAt"}),
    @UniqueConstraint(columnNames = {"billNo", "exportedAt", "customerTax"})
})
@Data
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UniqueId;

    // số hóa đơn (chỉ 1)
    @Column(name = "billNo", columnDefinition = "varchar(20)")
    private String BillNo;

    @Column(name = "totalMoney", columnDefinition = "float", nullable = false)
    private float TotalMoney;

    @Column(name = "totalLit", columnDefinition = "float", nullable = false)
    private float TotalLit;

    @Column(name = "statusCode", columnDefinition = "int(3)")
    private int StatusCode;

    @Column(name = "customerPhone", columnDefinition = "varchar(12)")
    private String CustomerPhone;

    @Column(name = "customerCardId", columnDefinition = "varchar(25)")
    private String CustomerCardId;

    @Column(name = "customerTax", columnDefinition = "varchar(10)")
    private String CustomerTax;

    @Column(name = "customerName", columnDefinition = "varchar(45)")
    private String CustomerName;

    @Column(name = "note", columnDefinition = "varchar(70)")
    private String Note;

    @Column(name = "exportedAt", columnDefinition = "datetime")
    @Temporal(TemporalType.DATE)
    private LocalDateTime ExportedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "transaction")
    List<Order> orders = new ArrayList<Order>();
}
