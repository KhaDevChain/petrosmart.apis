package com.factory.api2.services.sso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.repositories.sso.SupplierRepository;

@Service
public class SupplierService {
    @Autowired
    protected SupplierRepository supplierRepository;
}
