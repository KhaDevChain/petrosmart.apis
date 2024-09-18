package com.factory.api2.repositories.operation;

import org.springframework.data.jpa.repository.JpaRepository;

import com.factory.api2.ms.models.operation.Order;

public interface OrderRepository extends JpaRepository<Order, String>{
    
}
