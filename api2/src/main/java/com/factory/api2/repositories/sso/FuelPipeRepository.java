package com.factory.api2.repositories.sso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.factory.api2.models.sso.FuelPipe;

@Repository
public interface FuelPipeRepository extends JpaRepository<FuelPipe, String> {
    
}
