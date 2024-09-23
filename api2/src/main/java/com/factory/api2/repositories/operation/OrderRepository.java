package com.factory.api2.repositories.operation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.factory.api2.models.operation.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
