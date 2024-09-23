package com.factory.api2.repositories.operation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.factory.api2.models.operation.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    
}
