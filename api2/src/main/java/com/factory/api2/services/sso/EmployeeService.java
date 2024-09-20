package com.factory.api2.services.sso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.repositories.sso.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    protected EmployeeRepository employeeRepository;
}
