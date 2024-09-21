package com.factory.api2.models.sso;

import java.util.List;
import java.time.LocalDateTime;
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
 * vai trò
 */
@Entity
@Table(name = "roles", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"roleName", "rankest"}),
    @UniqueConstraint(columnNames = {"roleName", "rankest", "rankOrther"}),
})
@Data
public class Role {
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(50)")
    private String UniqueId;

    @Column(name = "roleName", columnDefinition = "varchar(70)", unique = true, nullable = false)
    private String RoleName;

    // chỉ mục phân cấp từ thấp đến cao (1,2,3)
    @Column(name = "rankest", columnDefinition = "int", nullable = false)
    private int Rankest = 1;
    
    // chỉ mục phân cấp con của rankest (1.1, 2.2, 1.2)
    @Column(name = "rankOrther", columnDefinition = "float")
    private float RankOrther;

    @Column(name = "createdAt", columnDefinition = "datetime")
    @Temporal(TemporalType.DATE)
    private LocalDateTime CreatedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "role")
    protected List<Permission> employees = new ArrayList<Permission>();
}
