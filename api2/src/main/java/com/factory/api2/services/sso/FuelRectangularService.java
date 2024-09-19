package com.factory.api2.services.sso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.repositories.sso.FuelRectangularRepository;

@Service
public class FuelRectangularService {
    @Autowired
    protected FuelRectangularRepository fuelRectangularRepository; 
}
