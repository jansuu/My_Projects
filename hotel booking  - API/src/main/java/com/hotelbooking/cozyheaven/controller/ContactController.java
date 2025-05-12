package com.hotelbooking.cozyheaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.model.Contact;
import com.hotelbooking.cozyheaven.service.ContactService;

@RestController
@RequestMapping("/api/contact")
public class ContactController 
{
	@Autowired
	private ContactService contactService;
	
	// add message
	@PostMapping("/add")
	public Contact addcontact(@RequestBody Contact contact)
	{
		return contactService.addcontact(contact);
	}

}
