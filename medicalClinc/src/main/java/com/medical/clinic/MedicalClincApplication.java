package com.medical.clinic;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class MedicalClincApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalClincApplication.class, args);
	}

	@Bean
	public GroupedOpenApi appointmentOpenApi(@Value("${springdoc.version}") String appVersion) {
		String[] paths = { "/appointment/**" };
		return GroupedOpenApi.builder().
				group("appointment")
				.addOpenApiCustomiser(openApi -> openApi.info(new Info()
						.title("Appointment API").version(appVersion)))
				.pathsToMatch(paths)
				.build();
	}
}
