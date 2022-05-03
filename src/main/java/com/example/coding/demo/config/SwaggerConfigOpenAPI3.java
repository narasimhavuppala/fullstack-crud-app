package com.example.coding.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfigOpenAPI3 {

    @Bean
    public OpenAPI buildOpenAPISpec() {
        return new OpenAPI()
                .info(new Info().title("Demo Crud APP API")
                        .description("Spring Crud Demo App")
                        .version("1.0.0-SNAPSHOT"));
    }
}
