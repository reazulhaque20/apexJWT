package com.apex.apexjwt;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "ApexJWT API", version = "2.0", description = "API Information"))
public class ApexJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApexJwtApplication.class, args);
    }

}
