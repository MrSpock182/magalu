package io.com.github.mrspock182.magalu.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

    @Value("${project.version}")
    private String version;

    @Value("${spring.application.name}")
    private String name;

    @Value("${project.description}")
    private String description;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("io.com.github.mrspock182.magalu"))
                .paths(PathSelectors.any()).build()
                .apiInfo(new ApiInfoBuilder().version(version)
                        .title(name)
                        .description(description).build());
    }

}
