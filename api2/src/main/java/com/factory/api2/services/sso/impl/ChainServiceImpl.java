package com.factory.api2.services.sso.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.repositories.sso.ChainRepository;
import com.factory.api2.services.sso.ChainService;

@Service
public class ChainServiceImpl implements ChainService {
    @Autowired
    protected ChainRepository chainRepository;
}
