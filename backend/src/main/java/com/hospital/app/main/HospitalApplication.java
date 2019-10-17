package com.hospital.app.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.hospital.app.*")
@EntityScan("com.hospital.app.*")   
@EnableJpaRepositories("com.hospital.app.repositories")

public class HospitalApplication  {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

}
