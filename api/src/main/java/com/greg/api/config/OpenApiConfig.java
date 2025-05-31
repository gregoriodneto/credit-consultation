package com.greg.api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Créditos API",
                version = "1.0",
                description = "API de consulta de créditos constituídos"
        )
)
public class OpenApiConfig {
}
