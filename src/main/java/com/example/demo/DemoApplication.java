package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public Docket swaggerConfiguration() {
        //  Return a prepared Docket instance
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //  Following .path() is not working properly. methods with @PathVariable is missing
//                .paths(PathSelectors.ant("/address-book/*"))
                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Custom API",
                "Sample API for learning purposes of Swagger",
                "1.0",
                "Full Free",
                new springfox.documentation.service.Contact("Shamin Asfaq", "https://www.google.com/", "a@b.com"),
                "API License",
                "https://www.google.com",
                Collections.emptyList()
        );
    }

}
