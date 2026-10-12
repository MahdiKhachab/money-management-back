package com.alzahraa.money.manegment.config;

import java.nio.file.Paths;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurer() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**")
	                    .allowedOriginPatterns("*")  // <-- Use allowedOriginPatterns here
	                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
	                    .allowedHeaders("*")
	                    .allowCredentials(true);
	        }

	        // Serve files saved by FileStorageService (same ./uploads directory)
	        @Override
	        public void addResourceHandlers(ResourceHandlerRegistry registry) {
	            String uploadDir = Paths.get("./uploads").toAbsolutePath().normalize().toUri().toString();
	            if (!uploadDir.endsWith("/")) {
	                uploadDir += "/";
	            }
	            registry.addResourceHandler("/api/public/uploads/**")
	                    .addResourceLocations(uploadDir);
	        }
	    };
	}
}