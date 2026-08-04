package com.umar.studentmanagementsystem.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI studentManagementOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Student Management System API")
                        .description("REST API Documentation for Student Management System")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Umar Farooq")
                                .email("farooq.personal12@gmail.com")
                                .url("https://github.com/farooqpersonal12"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")));
    }
}