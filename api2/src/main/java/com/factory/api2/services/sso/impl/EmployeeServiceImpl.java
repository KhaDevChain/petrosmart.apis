package com.factory.api2.services.sso.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.models.sso.Employee;
import com.factory.api2.repositories.sso.EmployeeRepository;
import com.factory.api2.services.sso.EmployeeService;

import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    protected EmployeeRepository employeeRepository;

    //#region Webflux

    @Override
    public Mono<Employee> findBySkuOrEmail_Mono(String key) {
        Employee employee = employeeRepository.findBySKUorEmail(key);
        return Mono.justOrEmpty(employee);
    }

    //#endregion

    

    //#region Basic

    @Override
    public Employee findBySkuOrEmail(String key) {
        return employeeRepository.findBySKUorEmail(key);
    }

    //#endregion
}
