package com.factory.api2.services.sso.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.repositories.sso.FuelPipeRepository;
import com.factory.api2.services.sso.FuelPipeService;

@Service
public class FuelPipeServiceImpl implements FuelPipeService {
    @Autowired
    protected FuelPipeRepository fuelPipeRepository;
}
