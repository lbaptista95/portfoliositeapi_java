package com.lb.portfolio.api.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringdocConfiguration {

    @Value("${springdoc.api-docs.swagger-title}")
    private String title;
    @Value("${springdoc.api-docs.swagger-description}")
    private String description;
    @Value("${springdoc.api-docs.version}")
    private String version;

    @Bean
    OpenAPI openApi() {
        return new OpenAPI().info(getInfo());
    }

    private Info getInfo() {
        return new Info().title(title).description(description).version(version);
    }

    /* API Groups */
    @Bean
    GroupedOpenApi all() {
        return GroupedOpenApi.builder().group("All").pathsToMatch("/**").build();
    }
}
