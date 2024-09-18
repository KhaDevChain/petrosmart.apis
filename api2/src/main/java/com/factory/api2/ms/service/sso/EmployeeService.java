package com.factory.api2.ms.service.sso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.ms.models.sso.Employee;
import com.factory.api2.repositories.sso.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    protected EmployeeRepository employeeRepository;

    public Employee getEmployeeById(String uniqueId) {
        return employeeRepository.findById(uniqueId).orElse(null);
    }

    public Employee saveEmployee(Employee employee) {
        try {
            employeeRepository.save(employee);
            return employee;
        } catch (Exception e) {
            return null;
        }
    }
}
