package com.factory.api2.services.sso.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.repositories.sso.StationRepository;
import com.factory.api2.services.sso.StationService;

@Service
public class StationServiceImpl implements StationService {
    @Autowired
    protected StationRepository stationRepository;
}
