package com.factory.api2.services.operation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.repositories.operation.TransactionRepository;
import com.factory.api2.services.operation.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    protected TransactionRepository transactionRepository;
}
