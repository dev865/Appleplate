package com.team.appleplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AppleplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppleplateApplication.class, args);
	}

}
