package com.factory.api2.services.einvoice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.repositories.einvoice.InvoiceRepository;
import com.factory.api2.services.einvoice.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    protected InvoiceRepository invoiceRepository;
}
