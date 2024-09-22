package com.factory.api2.security.jwt;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * ReactiveAuthenticationManager :
 * Đây là interface dùng riêng cho Spring Webflux dùng để tải UserDetail sua khi đã đi qua Filter
 * Nó sẽ không trả về trực tiếp UserDetail sau khi xử lý mà thay thành Mono<UserDetail> để xử lý xác thực bất đồng bộ
 * 
 * Lớp này được sử dụng nhằm mục đích xác thực token và quyền và trả về 1 Authentication
 */
@Component
@AllArgsConstructor
public class JwtAuthenticationManage implements ReactiveAuthenticationManager{

    private JwtUtil jwtUtil;

    @Override
    @SuppressWarnings("unchecked")
    public Mono<Authentication> authenticate(Authentication authentication) {
        // lấy token trong Authentication
        String token = authentication.getCredentials().toString();

        // lấy skuOrEmail trong token ra ngoài
        String skuOrEmail = jwtUtil.getSkuOrEmailFromToken(token);

        return  Mono.just(jwtUtil.validateToken(token)) // B1: kiểm tra token có hợp lệ không
                    .filter(valid -> valid)             // B2: kiểm tra sau khi filter có valid không
                    .switchIfEmpty(Mono.empty())        // B3: TH nếu là rỗng thì trả về 1 Mono rỗng
                    .map(valid -> {
                        Claims claims = jwtUtil.getAllClaimsFromToken(token); // B4: nếu là hợp lệ thì tiến hành lấy Claims để kiểm tra expire
                        List<String> rolesMap = claims.get("role", List.class); // B5: lấy danh sách role khi generateToken
                        return new UsernamePasswordAuthenticationToken(
                            skuOrEmail,
                            null,
                            rolesMap.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList())
                        );
                    });

    }
    
}
