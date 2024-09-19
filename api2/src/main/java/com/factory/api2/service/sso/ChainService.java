package com.factory.api2.service.sso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.repositories.sso.ChainRepository;

@Service
public class ChainService {
    @Autowired
    protected ChainRepository chainRepository;
}
