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
 * ủy quyền
 */
@Entity
@Table(
    name = "permissions",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = { "groupName", "groupPermission"})
    }
)
@Data
public class Permission implements Serializable{
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(50)")
    private String UniqueId;

    @Column(name = "groupName", columnDefinition = "varchar(20)", unique = true, nullable = false)
    private String GroupName;

    @Column(name = "groupPermission", columnDefinition = "varchar(300)", nullable = false)
    private String GroupPermission;

    @Column(name = "description", columnDefinition = "varchar(20)", nullable = false)
    private String Description;

    @Column(name = "activated", columnDefinition = "boolean")
    private boolean Activated = false;

    @Column(name = "createdAt", columnDefinition = "datetime")
    @Temporal(TemporalType.DATE)
    private LocalDateTime CreatedAt = LocalDateTime.now();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId", nullable = false)
    @JsonIgnore
    private Role role;
}
