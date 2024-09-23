package com.factory.api2.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * Lớp tùy chọn cho CORS
 * Tham khảo tại: https://viblo.asia/p/cors-la-gi-Qbq5Q0j3lD8
 */
@Configuration
@EnableWebFlux
public class CustomerWebConfig implements WebFluxConfigurer {

    @Override
    @SuppressWarnings("null")
    public void addCorsMappings(CorsRegistry registry) {
        registry
            .addMapping("/**") // chấp nhận toàn bộ mapping
            .allowedOrigins("*") // Chấp nhận dữ liệu dưới dạng http/https of URL
            .allowedMethods("*") // Chấp nhận tất cả dạng method get, post, put, delete
            .allowedHeaders("*"); // Chấp nhận dữ liệu lưu tại headers
    }
}
