package com.factory.api2.services.sso.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.repositories.sso.FuelRepository;
import com.factory.api2.services.sso.FuelService;

@Service
public class FuelServiceImpl implements FuelService {
    @Autowired
    protected FuelRepository fuelRepository;
}
