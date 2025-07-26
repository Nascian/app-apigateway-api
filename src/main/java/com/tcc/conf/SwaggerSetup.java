package com.tcc.conf;


// Java
import java.util.ArrayList;
import java.util.List;

// Spring
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

// Swagger Open API
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@Component
public class SwaggerSetup {
  
    // =======================================================================================
    // Open API Documentation Code
    // =======================================================================================

    /**
     * Open API v3 Docs - All
     * Reference: https://springdoc.org/faq.html
     * @return
     */
    @Bean
    public GroupedOpenApi allPublicApi() {
        return GroupedOpenApi.builder()
                .group(""+"-service")
                .pathsToMatch(""+"/**")
                .build();
    }

    /**
     * Open API v3 Docs - MicroService
     * Reference: https://springdoc.org/faq.html
     * @return
     */
    @Bean
    public GroupedOpenApi appPublicApi() {
        return GroupedOpenApi.builder()
                .group(""+"-service-core")
                .pathsToMatch("path"+"/**")
                .pathsToExclude("path"+"/service/**", "path"+"/config/**")
                .build();
    }

    /**
     * Open API v3 Docs - Core Service
     * Reference: https://springdoc.org/faq.html
     * Change the Resource Mapping in HealthController
     *
     * @see HealthController
     */
    @Bean
    public GroupedOpenApi configPublicApi() {
        return GroupedOpenApi.builder()
                .group(""+"-service-config")
                .pathsToMatch("path"+"/config/**")
                .build();
    }

    /**
     * System Public APIs
     * @return
     */
    @Bean
    public GroupedOpenApi systemPublicApi() {
        return GroupedOpenApi.builder()
                .group(""+"-service-health")
                .pathsToMatch("path"+"/service/**")
                .build();
    }

    /**
     * Open API v3
     * Reference: https://springdoc.org/faq.html
     * @return
     */
    @Bean
    public OpenAPI buildOpenAPI() {
        return new OpenAPI()
                .servers(getServers())
                .info(new Info()
                        .title(""+" Service")
                        .description("details")
                        .version("version")
                        .license(new License().name("License: ")
                                .url("serviceLicense"))
                )
                .externalDocs(new ExternalDocumentation()
                        .description(""+" Service Source Code")
                        .url("")
                )
                .components(new Components().addSecuritySchemes("bearer-key",
                        new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT"))
                );
    }

    /**
     * Get the List of Servers for Open API Docs - Swagger
     * @return
     */
    private List<Server> getServers() {
        List<Server> serverList = new ArrayList<>();
        Server dev = new Server();
        return serverList;
    }
}

