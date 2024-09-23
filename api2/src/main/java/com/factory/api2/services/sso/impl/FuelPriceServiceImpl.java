package com.factory.api2.services.sso.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.repositories.sso.FuelPriceRepository;
import com.factory.api2.services.sso.FuelPriceService;

@Service
public class FuelPriceServiceImpl implements FuelPriceService {
    @Autowired
    protected FuelPriceRepository fuelPriceRepository;
}
