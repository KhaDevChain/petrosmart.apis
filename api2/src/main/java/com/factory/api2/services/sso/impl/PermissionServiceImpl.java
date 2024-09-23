package com.factory.api2.services.sso.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.repositories.sso.PermissionRepository;
import com.factory.api2.services.sso.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    protected PermissionRepository permissionRepository;
}
