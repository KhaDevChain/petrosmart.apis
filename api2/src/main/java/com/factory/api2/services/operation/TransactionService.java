package com.factory.api2.services.operation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.repositories.operation.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    protected TransactionRepository transactionRepository;
}
