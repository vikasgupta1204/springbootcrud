package com.v1.springbootjpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootjpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(String[] args){
		return runner->{
			System.out.println("Hello World!!");
		};
	}

}
