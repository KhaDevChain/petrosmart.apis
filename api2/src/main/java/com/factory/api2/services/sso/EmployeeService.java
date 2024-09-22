package com.factory.api2.services.sso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.models.sso.Employee;
import com.factory.api2.repositories.sso.EmployeeRepository;

import reactor.core.publisher.Mono;

@Service
public class EmployeeService {
    @Autowired
    protected EmployeeRepository employeeRepository;

    //#region Web Flux
    
    public Mono<Employee> findBySkuOrEmail_Mono(String key) {
        Employee employee = employeeRepository.findBySKUorEmail(key);
        return Mono.justOrEmpty(employee);
    }

    //#endregion

    public Employee findBySkuOrEmail(String key) {
        return employeeRepository.findBySKUorEmail(key);
    }
}
