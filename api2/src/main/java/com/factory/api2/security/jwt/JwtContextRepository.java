package com.factory.api2.security.jwt;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * Tham khảo tại: https://www.likelion.edu.vn/blogs/su-dung-jwt-de-xac-thuc-va-uy-quyen-trong-spring-webflux
 */
@Component
@AllArgsConstructor
public class JwtContextRepository implements ServerSecurityContextRepository {

    private JwtAuthenticationManage jwtAuthenticationManage;

    @Override
    public Mono<SecurityContext> load(ServerWebExchange sw) {
        return Mono.justOrEmpty(sw.getRequest().getHeaders().getFirst("Authorization"))
                .filter(authHeader -> authHeader.startsWith("Bearer "))
                .flatMap(authHeader -> {
                    String authToken = authHeader.substring(7);
                    Authentication auth = new UsernamePasswordAuthenticationToken(authToken, authToken);
                    return this.jwtAuthenticationManage.authenticate(auth).map(SecurityContextImpl::new);
                });
    }

    @Override
    public Mono<Void> save(ServerWebExchange exchange, SecurityContext context) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
