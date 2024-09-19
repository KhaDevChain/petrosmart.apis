package com.factory.api2.service.sso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.repositories.sso.FuelPipeRepository;

@Service
public class FuelPipeService {
    @Autowired
    protected FuelPipeRepository fuelPipeRepository;
}
