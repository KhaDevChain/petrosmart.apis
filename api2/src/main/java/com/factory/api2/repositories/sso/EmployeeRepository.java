package com.factory.api2.repositories.sso;

import org.springframework.data.jpa.repository.JpaRepository;

import com.factory.api2.models.sso.Employee;

/**
 * EmployeeRepository
 */
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    
}