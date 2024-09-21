package com.factory.api2.models.einvoice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(
    name = "methodexports"
)
@Data
public class MethodExport {

    /**
     * auto
     * shift
     * stop
     */
    @Id
    @Column(name = "uniqueId", columnDefinition = "varchar(5)")
    private String UniqueId;

    @Column(name = "methodName", columnDefinition = "varchar(25)", nullable = false)
    private String methodName;
}
