package com.fc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BaseConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .maxAge(3600)
                .allowedMethods("POST", "PUT", "DELETE", "GET", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
