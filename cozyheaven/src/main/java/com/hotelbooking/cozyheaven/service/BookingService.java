package com.hotelbooking.cozyheaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.repository.BookingRepository;

@Service
public class BookingService 
{
	@Autowired
	private BookingRepository br;

}
