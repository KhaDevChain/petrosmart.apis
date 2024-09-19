package com.factory.api2.repositories.sso;

import org.springframework.data.jpa.repository.JpaRepository;

import com.factory.api2.ms.models.sso.ShiftChange;

public interface ShiftChangeRepository extends JpaRepository<ShiftChange, String> {
    
}
