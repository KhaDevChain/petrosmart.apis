package com.factory.api2.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.factory.api2.security.jwt.JwtAuthenticationManage;
import com.factory.api2.security.jwt.JwtContextRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * Đây là thông tin để cấu hình http cần xác nhận token cho các domain
 */
@AllArgsConstructor
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
@Configuration
public class WebSecurityConfig {
    private JwtAuthenticationManage jwtAuthenticationManage;
    private JwtContextRepository jwtContextRepository;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
            .httpBasic(httpBasic -> httpBasic.disable())
            .formLogin(formLogin -> formLogin.disable())
            .csrf(csrf -> csrf.disable())
            .logout(logout -> logout.disable());
        
        http
            .exceptionHandling(exceptionHandlingSpec -> 
                exceptionHandlingSpec
                    .authenticationEntryPoint(
                        (swe, e) -> Mono.fromRunnable(() -> swe.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED))) 
                    .accessDeniedHandler (
                        (swe, e) -> Mono.fromRunnable(() -> swe.getResponse().setStatusCode(HttpStatus.FORBIDDEN))
            ))
            .authenticationManager(jwtAuthenticationManage)
            .securityContextRepository(jwtContextRepository)
            .authorizeExchange(authorizeExchangeSpec -> 
                authorizeExchangeSpec
                        .pathMatchers(HttpMethod.OPTIONS)
                        .permitAll()
                        .pathMatchers("/login").permitAll()
                        .pathMatchers("/**").permitAll()
                        .anyExchange().authenticated()
            );

        return http.build();
    }
}
