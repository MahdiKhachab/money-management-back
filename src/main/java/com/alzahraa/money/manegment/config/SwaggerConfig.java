package com.alzahraa.money.manegment.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Al-Zahraa Association API")
                .version("1.0.0")
                .description("API documentation for managing donors, income, expenses and more.")
                .contact(new Contact()
                    .name("Al-Zahraa IT Team")
                    .email("support@alzahraa.org")
                )
                .license(new License()
                    .name("Apache 2.0")
                    .url("http://springdoc.org")));
    }
}
