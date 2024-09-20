package com.factory.api2.repositories.einvoice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.factory.api2.models.einvoice.MethodExport;

public interface MethodExportRepository extends JpaRepository<MethodExport, String> {
    
}
