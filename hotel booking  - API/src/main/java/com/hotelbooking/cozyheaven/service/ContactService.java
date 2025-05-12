package com.hotelbooking.cozyheaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.model.Contact;
import com.hotelbooking.cozyheaven.repository.ContactRepository;

@Service
public class ContactService 
{
	@Autowired
	private ContactRepository contactRepository;

	public Contact addcontact(Contact contact) 
	{
		// TODO Auto-generated method stub
		return contactRepository.save(contact);
	}

}
