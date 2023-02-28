package com.valorantwiki.valorant_maps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class ValorantMapsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValorantMapsApplication.class, args);
	}

}
