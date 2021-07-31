package com.example.project3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author 橙鼠鼠
 */
@SpringBootApplication
@EnableOpenApi
@EnableTransactionManagement
@EnableScheduling
public class Project3Application {

	public static void main (String[] args) {
		SpringApplication.run(Project3Application.class, args);
	}

}
