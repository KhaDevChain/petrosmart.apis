package com.factory.api2.service.sso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.repositories.sso.RoleRepository;

@Service
public class RoleService {
    @Autowired
    protected RoleRepository roleRepository;
}
