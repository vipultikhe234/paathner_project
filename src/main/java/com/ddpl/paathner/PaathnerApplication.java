package com.ddpl.paathner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = "com.ddpl.paathner")
@EnableJpaAuditing
public class PaathnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaathnerApplication.class, args);
	}

}
