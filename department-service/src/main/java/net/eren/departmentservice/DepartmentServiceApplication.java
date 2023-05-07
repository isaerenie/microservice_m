package net.eren.departmentservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "Department API",
                version = "1.0",
                description = "Documentation Department API v1.0",
                contact = @io.swagger.v3.oas.annotations.info.Contact(
                        name = "Eren",
                        email = "eren@gmail.com",
                        url = "javaer.com"
                ),
                license = @io.swagger.v3.oas.annotations.info.License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"
                )
        ),
        servers = {
                @io.swagger.v3.oas.annotations.servers.Server(
                        description = "Localhost",
                        url = "http://localhost:8080"
                )
        },
        tags = {
                @io.swagger.v3.oas.annotations.tags.Tag(
                        name = "Department Service",
                        description = "This is a sample Department service"
                )
        }, externalDocs = @io.swagger.v3.oas.annotations.ExternalDocumentation(
        description = "Department Service  Documentation",
        url = "https://springdoc.org/"
)
)
@SpringBootApplication
public class DepartmentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DepartmentServiceApplication.class, args);
    }

}
