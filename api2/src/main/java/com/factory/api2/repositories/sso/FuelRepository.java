package com.factory.api2.repositories.sso;

import org.springframework.data.jpa.repository.JpaRepository;

import com.factory.api2.ms.models.sso.Fuel;

public interface FuelRepository extends JpaRepository<Fuel, String> {
    
}
