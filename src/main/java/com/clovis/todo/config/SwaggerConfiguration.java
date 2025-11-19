package com.clovis.todo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.Components;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("To-Do List REST API")
                        .description("To-Do List API documentation")
                        .version("v1"))
                .addSecurityItem(new SecurityRequirement().addList("JWT"))
                .components(new Components());
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("REST API V1")
                .packagesToScan("com.clovis.todo") // ✔️ Correction ici
                .pathsToMatch("/**")
                .build();
    }
}

