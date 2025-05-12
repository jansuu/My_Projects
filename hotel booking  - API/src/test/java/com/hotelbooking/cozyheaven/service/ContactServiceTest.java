package com.hotelbooking.cozyheaven.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.hotelbooking.cozyheaven.model.Contact;
import com.hotelbooking.cozyheaven.repository.ContactRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ContactServiceTest 
{
	@InjectMocks
	private ContactService contactService;
	
	@Mock
	private ContactRepository contactRepository;
	
	Contact c1;
	Contact c2;

	@BeforeEach
	public void init() 
	{

		c1 = new Contact(1L, "Alice Johnson", "alice@example.com", "I would like to inquire about room availability for next weekend.");
		c2 = new Contact(2L, "Bob Smith", "bob@example.com", "Great website! Very easy to use and helpful.");
	}
	
	@Test
	public void addcontact() 
	{
		when(contactRepository.save(c2)).thenReturn(c1);
		assertEquals(c1, contactService.addcontact(c2));
	}


}
