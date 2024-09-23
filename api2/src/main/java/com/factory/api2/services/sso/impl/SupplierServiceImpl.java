package com.factory.api2.services.sso.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.repositories.sso.SupplierRepository;
import com.factory.api2.services.sso.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    protected SupplierRepository supplierRepository;
}
