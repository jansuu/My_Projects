package com.hotelbooking.cozyheaven.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class HotelOwnerHasVerficationRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private VerificationRequest verificationRequest;
	
	@ManyToOne
	private HotelOwner hotelOwner;

}
