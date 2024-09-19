package com.factory.api2.service.einvoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.repositories.einvoice.MethodExportRepository;

@Service
public class MethodExportService {
    @Autowired
    protected MethodExportRepository methodExportRepository;
}
