package com.factory.api2.security.jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.factory.api2.models.sso.Employee;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;

/**
 * Đây là lớp dùng để chuyển xử lý các vấn đề liên quan token như lấy dữ liệu, tạo token, và kiểm tra hiệu lực
 */
@Component
public class JwtUtil {

    @Value("${springbootwebfluxjjwt.jjwt.secret}")
    private String secret;

    @Value("${springbootwebfluxjjwt.jjwt.expiration}")
    private String expirationTime;

    private Key key;

    /**
     * Mã hóa key thành hmac thay vì dùng serect trực tiếp
     */
    @PostConstruct
    public void init() {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    //#region ĐỌC
    
    /**
     * trong payload ngoài những json truyền vào thì còn có thêm 1 số thông tin
     * iss  sub  aud ... thì đó gọi là Claims
     * @param token
     * @return
     */
    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key)
                   .build()
                   .parseClaimsJws(token)
                   .getBody();
    }

    /**
     * lấy thông tin sku or email từ trong token đó
     * skuOrEmail (giống như username) chính là khi login vào
     * @param token
     * @return
     */
    public String getSkuOrEmailFromToken(String token) {
        return getAllClaimsFromToken(token).getSubject();
    }

    /**
     * lấy thời gian hiệu lực của token
     * @param token
     * @return
     */
    public Date getExpirationDateFromToken(String token) {
        Date expirationDate = getAllClaimsFromToken(token).getExpiration();
        return expirationDate;
    }

    /**
     * kiểm tra thời gian hiệu lực so với thời gian hiện tại
     * @param token
     * @return
     */
    public boolean isExpiredDateToken(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    //#endregion
    
    //#region VIẾT

    /**
     * chuẩn bị dữ liệu Map để tạo 1 token tổng quan
     * @param skuOrEmail
     * @return
     */
    public String generateToken(Employee employee) {
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("role", employee.getRole());
        String token = createToken(claims, employee.getSKU());
        return token;
    }

    /**
     * tạo 1 token với claims và subject truyền vào
     * @param claims
     * @param skuOrEmail
     * @return
     */
    private String createToken(Map<String, Object> claims, String skuOrEmail) {
        Long expirationTimeLong = Long.parseLong(expirationTime);
        final Date createdDate = new Date();
        final Date expiredDate = new Date(createdDate.getTime() + expirationTimeLong * 1000);
        
        return Jwts.builder()
                   .setClaims(claims)
                   .setSubject(skuOrEmail)
                   .setIssuedAt(createdDate)
                   .setExpiration(expiredDate)
                   .signWith(key)
                   .compact();
    }

    /**
     * kiểm tra token có hợp lệ không
     * @param token
     * @return
     */
    public Boolean validateToken(String token) {
        return !isExpiredDateToken(token);
    }

    //#endregion

}
