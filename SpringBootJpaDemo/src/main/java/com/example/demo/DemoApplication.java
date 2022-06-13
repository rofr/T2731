package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner run(CrudRepository<Contact,Integer> contactsRepo) {
		return (String[] args) -> {
			var contact = new Contact();
			contact.setId(42);
			contact.setName("Bob");
			contact.setNumber("123456");
			contactsRepo.save(contact);
		};
	}

}
