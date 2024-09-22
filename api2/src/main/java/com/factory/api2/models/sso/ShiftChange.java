package com.factory.api2.models.sso;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * giao ca
 */
@Entity
@Table(
    name = "shiftchanges"
)
@Data
public class ShiftChange {
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(50)")
    private String UniqueId;

    @Column(name = "fromTime", columnDefinition = "varchar(12)", nullable = false)
    private String FromTime;

    @Column(name = "toTime", columnDefinition = "varchar(12)", nullable = false)
    private String ToTime;

    @Column(name = "createdAt", columnDefinition = "datetime")
    private LocalDateTime CreatedAt = LocalDateTime.now();
}