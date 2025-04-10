package com.hotelbooking.cozyheaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.HotelOwner;
import com.hotelbooking.cozyheaven.model.OwnerVerificationReq;
import com.hotelbooking.cozyheaven.model.VerificationRequest;
import com.hotelbooking.cozyheaven.service.OwnerVerficationReqService;
import com.hotelbooking.cozyheaven.service.HotelOwnerService;
import com.hotelbooking.cozyheaven.service.VerificationRequestService;

@RestController
@RequestMapping("/api/hotelowner_has_verificationrequest")
public class OwnerVerficationReqController {
	
	@Autowired
	private OwnerVerficationReqService ownerVerficationReqService;
	@Autowired
	private HotelOwnerService hotelOwnerService;
	@Autowired
	private VerificationRequestService verificationRequestService;
	
	@PostMapping("/assign/{ownerID}/{verificationID}")
	public  OwnerVerificationReq assignRequest(@PathVariable int ownerID,@PathVariable int verificationID,@RequestBody OwnerVerificationReq assign) throws InvalidIDException {
		
		HotelOwner owner= hotelOwnerService.getOwnerByID(ownerID);
		VerificationRequest request=verificationRequestService.findByID(verificationID);
		assign.setHotelOwner(owner);
		assign.setVerificationRequest(request);
		return ownerVerficationReqService.assignRequest(assign);
		
		
		
	}
	
	

}
