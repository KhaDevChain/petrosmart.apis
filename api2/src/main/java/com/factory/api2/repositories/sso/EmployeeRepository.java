package com.factory.api2.repositories.sso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.factory.api2.models.sso.Employee;

/**
 * EmployeeRepository
 */
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    /**
     * lấy employee với sku hoặc email
     * @param data
     * @return
     */
    @Query("SELECT o FROM Employee o WHERE o.SKU = ?1 OR o.Email = ?1 ")
    public Employee findBySKUorEmail(String data);
}