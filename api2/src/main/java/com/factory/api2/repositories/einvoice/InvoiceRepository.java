package com.factory.api2.repositories.einvoice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.factory.api2.models.einvoice.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    
}
