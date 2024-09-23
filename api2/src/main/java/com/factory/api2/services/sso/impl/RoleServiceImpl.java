package com.factory.api2.services.sso.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.repositories.sso.RoleRepository;
import com.factory.api2.services.sso.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    protected RoleRepository roleRepository;
}
