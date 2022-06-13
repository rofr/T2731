package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
	
	CrudRepository<Contact, Integer> contacts;
	
	public ContactController(CrudRepository<Contact, Integer> contacts) {
		this.contacts = contacts;
	}

	@GetMapping("/contact")
	public Contact contactById() {
//		var contact = new Contact();
//		contact.setId(42);
//		contact.setName("Bob");
//		contact.setNumber("4242");
		
		var contact = contacts.findById(42);
		return contact.get();
	}


}
