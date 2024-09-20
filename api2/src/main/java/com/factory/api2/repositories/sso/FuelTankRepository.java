package com.factory.api2.repositories.sso;

import org.springframework.data.jpa.repository.JpaRepository;

import com.factory.api2.models.sso.FuelTank;

public interface FuelTankRepository extends JpaRepository<FuelTank, String> {
    
}
