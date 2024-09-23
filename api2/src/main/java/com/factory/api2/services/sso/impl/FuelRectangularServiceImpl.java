package com.factory.api2.services.sso.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.repositories.sso.FuelRectangularRepository;
import com.factory.api2.services.sso.FuelRectangularService;

@Service
public class FuelRectangularServiceImpl implements FuelRectangularService {
    @Autowired
    protected FuelRectangularRepository fuelRectangularRepository; 
}
