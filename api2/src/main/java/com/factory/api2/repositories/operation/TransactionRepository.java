package com.factory.api2.repositories.operation;

import org.springframework.data.jpa.repository.JpaRepository;

import com.factory.api2.models.operation.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    
}
