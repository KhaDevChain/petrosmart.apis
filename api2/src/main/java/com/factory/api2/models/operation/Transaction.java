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
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

/**
 * Transaction sử dụng nhằm giữ lại các giao dịch khi xuất hóa đơn của công nợ
 */
@Entity
@Table(name = "transactions", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"billNo", "createdAt"})
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

    @Column(name = "customerId", columnDefinition = "varchar(50)")
    private String CustomerId;

    @Column(name = "customerName", columnDefinition = "varchar(45)")
    private String CustomerName;

    @Column(name = "note", columnDefinition = "varchar(70)")
    private String Note;

    @Column(name = "fastId", columnDefinition = "int(1)")
    private int FastId;

    @Column(name = "vnptId", columnDefinition = "int(1)")
    private int VnptId;

    @Column(name = "misaId", columnDefinition = "int(1)")
    private int MisaId;

    @Column(name = "createdAt", columnDefinition = "datetime")
    private LocalDateTime CreatedAt = LocalDateTime.now();

    @Column(name = "updatedAt", columnDefinition = "datetime")
    private LocalDateTime UpdatedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "transaction")
    List<Order> orders = new ArrayList<Order>();
}
