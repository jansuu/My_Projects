package com.hotelbooking.cozyheaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.repository.HotelOwnerHasVerficationRequestRepository;

@Service
public class HotelOwnerHasVerficationRequestService {
	@Autowired
	private HotelOwnerHasVerficationRequestRepository hotelOwnerHasVerficationRequestRepository;

}
