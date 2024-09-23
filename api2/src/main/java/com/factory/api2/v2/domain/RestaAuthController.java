package com.factory.api2.v2.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.factory.api2.security.encoder.PBKDF2PasswordEncoder;
import com.factory.api2.security.jwt.JwtUtil;
import com.factory.api2.services.sso.EmployeeService;
import com.factory.api2.utils.model_.payload.request.LoginRequest;
import com.factory.api2.utils.model_.payload.request.SignupRequest;
import com.factory.api2.utils.model_.payload.response.LoginResponse;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@AllArgsConstructor
public class RestaAuthController {
    
    private JwtUtil jwtUtil;

    private PBKDF2PasswordEncoder passwordEncoder;
    
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public Mono<ResponseEntity<LoginResponse>> login(@RequestBody LoginRequest login) {
        return employeeService.findBySkuOrEmail_Mono(login.getSkuOrEmail())
                              .filter(userDetails -> 
                                    passwordEncoder.encode(login.getPassword())
                                                   .equals(userDetails.getPassword()) )
                              .map(userDetails -> ResponseEntity.ok(new LoginResponse(jwtUtil.generateToken(userDetails)) ))
                              .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()));
    }
    
    @PostMapping("/signup")
    public Mono<ResponseEntity<SignupRequest>> signup(@RequestBody SignupRequest signup) {
        
        return null;
    }
    
}
