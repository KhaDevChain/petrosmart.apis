package com.factory.api2.services.sso.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.repositories.sso.CustomerRepository;
import com.factory.api2.services.sso.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    protected CustomerRepository customerRepository;
}
