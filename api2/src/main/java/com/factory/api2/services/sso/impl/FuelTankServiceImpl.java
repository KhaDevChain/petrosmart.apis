package com.factory.api2.services.sso.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.repositories.sso.FuelTankRepository;
import com.factory.api2.services.sso.FuelTankService;

@Service
public class FuelTankServiceImpl implements FuelTankService {
    @Autowired
    protected FuelTankRepository fuelTankRepository;
}
