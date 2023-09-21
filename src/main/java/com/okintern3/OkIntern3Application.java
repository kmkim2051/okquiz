package com.okintern3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OkIntern3Application {

	public static void main(String[] args) {
		SpringApplication.run(OkIntern3Application.class, args);
	}

}
