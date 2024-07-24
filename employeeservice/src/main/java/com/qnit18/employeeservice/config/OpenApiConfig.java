package com.qnit18.employeeservice.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Employee Api Specification - QNit18",
                description = "Api documentation for Employee Service",
                version = "1.0",
                contact = @Contact(
                        name = "Van Quang",
                        email = "vanquang1833@gmail.com",
                        url = "https://vietnamtadeplam.vn"
                ),
                license = @License(
                        name = "MIT License",
                        url = "https://vietnamtadeplam.vn/license"
                ),
                termsOfService = "https://vietnamtadeplam.vn/terms"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:9002"
                ),
                @Server(
                        description = "Dev ENV",
                        url = "http://employee-service.dev.com"
                ),
                @Server(
                        description = "Prod ENV",
                        url = "http://employee-service.prod.com"
                )
        }
)

public class OpenApiConfig {
}
