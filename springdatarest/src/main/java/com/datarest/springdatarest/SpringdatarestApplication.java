package com.datarest.springdatarest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.datarest.springdatarest.entity.User;
import com.datarest.springdatarest.repository.UserRepository;

@SpringBootApplication
public class SpringdatarestApplication implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(SpringdatarestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user=User.builder().firstName("Ramesh").lastName("Singh").email("ramesh@gmail.com").build();
		userRepository.save(user);
		User user1=User.builder().firstName("Mohit").lastName("Gupta").email("mohit@gmail.com").build();
		userRepository.save(user1);
		
		User user2=User.builder().firstName("Jay").lastName("Kumar").email("jay@gmail.com").build();
		userRepository.save(user2);
		User user3=User.builder().firstName("Vijay").lastName("Verma").email("vijay@gmail.com").build();
		userRepository.save(user3);
		
	}

}
