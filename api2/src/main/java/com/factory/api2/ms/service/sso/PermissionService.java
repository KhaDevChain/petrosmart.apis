package com.factory.api2.ms.service.sso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.api2.ms.models.sso.Permission;
import com.factory.api2.repositories.sso.PermissionRepository;

@Service
public class PermissionService {
    @Autowired
    protected PermissionRepository permissionRepository;

    public Permission getPermissionById(String uniqueId) {
        return permissionRepository.findById(uniqueId).orElse(null);
    }

    public Boolean containGroupPermission(String uniqueId, String group) {
        Permission permission = permissionRepository.findById(uniqueId).orElse(null);
        return permission == null ? false : 
                            permission.getGroupPermission()
                                      .contains(group);
    }

    public Permission savePermission(Permission permission) {
        try {
            permissionRepository.save(permission);
            return permission;
        } catch (Exception e) {
            return null;
        }
    }

    public String deletPermission(String uniqueId) {
        try {
            permissionRepository.deleteById(uniqueId);
            return uniqueId;
        } catch (Exception e) {
            return null;
        }
    }
}
