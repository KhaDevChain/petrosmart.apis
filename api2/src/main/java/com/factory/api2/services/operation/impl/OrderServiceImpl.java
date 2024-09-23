package com.factory.api2.services.operation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.repositories.operation.OrderRepository;
import com.factory.api2.services.operation.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    protected OrderRepository orderRepository;
}
