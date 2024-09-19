package com.factory.api2.ms.models.sso;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

/**
 * chuỗi xăng
 */
@Entity
@Table(
    name = "shiftChanges"
)
@Data
public class ShiftChange {
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(50)")
    private String UniqueId;

    @Column(name = "fromTime", columnDefinition = "varchar(12)", nullable = false)
    private String fromTime;

    @Column(name = "toTime", columnDefinition = "varchar(12)", nullable = false)
    private String toTime;

    @Column(name = "createdAt", columnDefinition = "datetime")
    @Temporal(TemporalType.DATE)
    private Date CreatedAt = new Date();
}