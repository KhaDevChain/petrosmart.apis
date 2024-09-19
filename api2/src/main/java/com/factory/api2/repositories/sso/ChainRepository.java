package com.factory.api2.repositories.sso;

import org.springframework.data.jpa.repository.JpaRepository;

import com.factory.api2.models.sso.Chain;

public interface ChainRepository extends JpaRepository<Chain, String> {
    
}
