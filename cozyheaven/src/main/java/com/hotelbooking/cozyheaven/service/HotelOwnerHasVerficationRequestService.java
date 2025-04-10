package com.hotelbooking.cozyheaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.model.HotelOwnerHasVerficationRequest;
import com.hotelbooking.cozyheaven.model.VerificationRequest;
import com.hotelbooking.cozyheaven.repository.HotelOwnerHasVerficationRequestRepository;

@Service
public class HotelOwnerHasVerficationRequestService {
	@Autowired
	private HotelOwnerHasVerficationRequestRepository hotelOwnerHasVerficationRequestRepository;

	public HotelOwnerHasVerficationRequest assignRequest(HotelOwnerHasVerficationRequest assign) {
		
		return hotelOwnerHasVerficationRequestRepository.save(assign);
	}


}
