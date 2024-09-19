package com.factory.api2.service.sso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.repositories.sso.FuelPriceRepository;

@Service
public class FuelPriceService {
    @Autowired
    protected FuelPriceRepository fuelPriceRepository;
}
