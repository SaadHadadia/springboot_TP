package com.example;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LoginExampleApplication {

	@Bean
	ModelMapper modelMApper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(LoginExampleApplication.class, args);
	}

}
