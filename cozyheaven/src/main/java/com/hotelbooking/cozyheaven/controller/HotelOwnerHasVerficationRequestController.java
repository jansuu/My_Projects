package com.hotelbooking.cozyheaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.HotelOwner;
import com.hotelbooking.cozyheaven.model.HotelOwnerHasVerficationRequest;
import com.hotelbooking.cozyheaven.model.VerificationRequest;
import com.hotelbooking.cozyheaven.service.HotelOwnerHasVerficationRequestService;
import com.hotelbooking.cozyheaven.service.HotelOwnerService;
import com.hotelbooking.cozyheaven.service.VerificationRequestService;

@RestController
@RequestMapping("/api/hotelowner_has_verificationrequest")
public class HotelOwnerHasVerficationRequestController {
	
	@Autowired
	private HotelOwnerHasVerficationRequestService hotelOwnerHasVerficationRequestService;
	@Autowired
	private HotelOwnerService hotelOwnerService;
	@Autowired
	private VerificationRequestService verificationRequestService;
	
	@PostMapping("/assign/{rID}/{vID}")
	public  HotelOwnerHasVerficationRequest assignRequest(@PathVariable int rID,@PathVariable int vID,@RequestBody HotelOwnerHasVerficationRequest assign) throws InvalidIDException {
		
		HotelOwner owner= hotelOwnerService.getOwnerByID(rID);
		VerificationRequest request=verificationRequestService.findByID(vID);
		assign.setHotelOwner(owner);
		assign.setVerificationRequest(request);
		return hotelOwnerHasVerficationRequestService.assignRequest(assign);
		
		
		
	}
	
	

}
