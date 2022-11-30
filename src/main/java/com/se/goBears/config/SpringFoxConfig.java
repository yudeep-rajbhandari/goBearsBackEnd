package com.se.goBears.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {


    @Bean
    public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .apis(RequestHandlerSelectors.basePackage("com.se.goBears"))
            .paths(PathSelectors.any())
            .build();
}

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Sig-Predict REST API Document")
                .description("work in progress")
                .termsOfServiceUrl("localhost")
                .version("1.0")
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("jwtToken", "Authorization", "header");
    }
}
