package com.example.demo4;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(
				title="sb documn",
				description="sb rest api",
				version="v1.0",
				contact=@Contact(
						name="raghu",
						email="raghavendr@gmail.com",
						url="https://www.raghu.com"
		),
				license = @License(
				name="apache 2.0",
				url="rr.com/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "sb",
				url = "raghu.com"
		)
)
public class Demo4Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo4Application.class, args);
	}

}
