package com.example.pib2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();

        // 🔹 Orígenes permitidos
        config.setAllowedOrigins(List.of(
                "http://localhost:3000", // Frontend local
                "http://ALB-Ecs-API-artesanias-1720835229.us-east-1.elb.amazonaws.com" // ALB HTTP
        ));

        // 🔹 Métodos HTTP permitidos
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"));

        // 🔹 Headers permitidos
        config.setAllowedHeaders(List.of("*"));

        // 🔹 Permitir credenciales (cookies, auth headers, etc.)
        config.setAllowCredentials(true);

        // 🔹 Registrar configuración para todas las rutas
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }
}
