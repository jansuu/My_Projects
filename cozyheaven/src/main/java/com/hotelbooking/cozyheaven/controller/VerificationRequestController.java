package com.hotelbooking.cozyheaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.HotelOwner;
import com.hotelbooking.cozyheaven.model.VerificationRequest;
import com.hotelbooking.cozyheaven.service.HotelOwnerService;
import com.hotelbooking.cozyheaven.service.VerificationRequestService;

@RestController
@RequestMapping("/api/verificationrequest")
public class VerificationRequestController {
	
	@Autowired
	private VerificationRequestService verificationRequestService;
	@Autowired
	private HotelOwnerService hotelOwnerService;
	
	@PostMapping("/add/{hotelOwnerID}")
	public VerificationRequest sendRequest(@PathVariable int hotelOwnerID,@RequestBody VerificationRequest request) throws InvalidIDException {
		
		HotelOwner owner= hotelOwnerService.getOwnerByID(hotelOwnerID);
		return verificationRequestService.sendRequest(request);
		
		
		
	}

}
