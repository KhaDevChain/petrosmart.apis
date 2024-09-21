package com.factory.api2.repositories.sso;

import org.springframework.data.jpa.repository.JpaRepository;

import com.factory.api2.models.sso.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    
}
