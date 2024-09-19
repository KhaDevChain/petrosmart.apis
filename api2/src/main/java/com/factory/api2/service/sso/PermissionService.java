package com.factory.api2.service.sso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.repositories.sso.PermissionRepository;

@Service
public class PermissionService {
    @Autowired
    protected PermissionRepository permissionRepository;
}
