package com.hotelbooking.cozyheaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.repository.HotelOwnerRepository;

@Service
public class HotelOwnerService 
{
	@Autowired
	private HotelOwnerRepository hotelOwnerRepository;

}
