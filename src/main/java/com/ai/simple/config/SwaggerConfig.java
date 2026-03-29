package com.ai.simple.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "AI Transaction API",
                version = "1.0",
                description = "API for AI transactions, including intelligent routing to Llama, Phi, and Coder models. Provides endpoints for querying AI models."
        )
)
public class SwaggerConfig {
}