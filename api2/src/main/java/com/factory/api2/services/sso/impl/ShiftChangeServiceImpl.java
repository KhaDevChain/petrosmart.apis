package com.factory.api2.services.sso.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.repositories.sso.ShiftChangeRepository;
import com.factory.api2.services.sso.ShiftChangeService;

@Service
public class ShiftChangeServiceImpl implements ShiftChangeService {
    @Autowired
    protected ShiftChangeRepository shiftChangeRepository;
}
