package com.finance.tracker.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${frontend.base.url}")
    private String frontEndBaseUrl;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // aplica a todas las rutas
                .allowedOrigins(frontEndBaseUrl,"http://localhost:5173") // frontend en Next.js
                .allowedMethods("GET", "POST", "PUT", "DELETE") // métodos permitidos
                .allowedHeaders("*"); // permite todos los headers
    }
}
