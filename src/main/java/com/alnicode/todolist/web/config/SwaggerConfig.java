package com.alnicode.todolist.web.config;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import static com.alnicode.todolist.util.AppConstants.APP_DESCRIPTION;
import static com.alnicode.todolist.util.AppConstants.APP_LICENSE;
import static com.alnicode.todolist.util.AppConstants.APP_LICENSE_URL;
import static com.alnicode.todolist.util.AppConstants.APP_TITLE;
import static com.alnicode.todolist.util.AppConstants.BASE_PACKAGE;
import static com.alnicode.todolist.util.AppConstants.CONTACT_EMAIL;
import static com.alnicode.todolist.util.AppConstants.CONTACT_NAME;
import static com.alnicode.todolist.util.AppConstants.CONTACT_URL;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(List.of(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .build()
                .apiInfo(this.info());
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT Token", "Authorization", "header");
    }

    private ApiInfo info() {
        return new ApiInfoBuilder()
                .contact(this.contact())
                .title(APP_TITLE)
                .description(APP_DESCRIPTION)
                .license(APP_LICENSE)
                .licenseUrl(APP_LICENSE_URL)
                .build();
    }
    
    private Contact contact() {
        return new Contact(
                CONTACT_NAME,
                CONTACT_URL,
                CONTACT_EMAIL);
    }

}
