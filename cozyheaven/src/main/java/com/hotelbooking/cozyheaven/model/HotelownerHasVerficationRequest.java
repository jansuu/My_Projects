package com.hotelbooking.cozyheaven.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class HotelownerHasVerficationRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private VerificationRequest verificationrequest;
	
	@ManyToOne
	private HotelOwner hotelowner;

}
