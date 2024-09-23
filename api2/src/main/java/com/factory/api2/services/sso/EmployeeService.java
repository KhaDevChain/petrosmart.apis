package com.factory.api2.services.sso;

import com.factory.api2.models.sso.Employee;

import reactor.core.publisher.Mono;

public interface EmployeeService {

    //#region Web Flux
    
    public Mono<Employee> findBySkuOrEmail_Mono(String key);

    //#endregion

    public Employee findBySkuOrEmail(String key);
}
