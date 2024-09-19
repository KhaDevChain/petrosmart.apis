package com.factory.api2.service.sso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.repositories.sso.ShiftChangeRepository;

@Service
public class ShiftChangeService {
    @Autowired
    protected ShiftChangeRepository shiftChangeRepository;
}
