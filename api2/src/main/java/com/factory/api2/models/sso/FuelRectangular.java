package com.factory.api2.models.sso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
 * trụ xăng
 */
@Entity
@Table(name = "fuelrectangulars", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"totalAClock", "totalBClock"}),
    @UniqueConstraint(columnNames = {"uniqueId", "totalAClock", "totalBClock"}),
})
@Data
public class FuelRectangular implements Serializable {
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(50)")
    private String UniqueId;

    // số trên đồng hồ total sau
    @Column(name = "totalAClock", columnDefinition = "varchar(9)", nullable = false)
    private String TotalAClock = "000000000";

    // số trên đồng hồ total trước
    @Column(name = "totalBClock", columnDefinition = "varchar(9)", nullable = false)
    private String TotalBClock = "000000000";

    // số lượng vòi vơm trên 1 trụ
    @Column(name = "numberPipe", columnDefinition = "int(1)", nullable = false)
    private int NumberPipe;

    @Column(name = "createdAt", columnDefinition = "datetime")
    @Temporal(TemporalType.DATE)
    private Date CreatedAt = new Date();

    @Column(name = "activated", columnDefinition = "boolean")
    private boolean Activated = false;

    @OneToMany(mappedBy = "fuelRectangular")
    List<FuelPipe> fuelPipes = new ArrayList<FuelPipe>();
}
