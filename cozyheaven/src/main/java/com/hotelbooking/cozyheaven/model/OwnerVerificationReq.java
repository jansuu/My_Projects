package com.hotelbooking.cozyheaven.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class OwnerVerificationReq {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private VerificationRequest verificationRequest;
	
	@ManyToOne
	private HotelOwner hotelOwner;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public VerificationRequest getVerificationRequest() {
		return verificationRequest;
	}

	public void setVerificationRequest(VerificationRequest verificationRequest) {
		this.verificationRequest = verificationRequest;
	}

	public HotelOwner getHotelOwner() {
		return hotelOwner;
	}

	public void setHotelOwner(HotelOwner hotelOwner) {
		this.hotelOwner = hotelOwner;
	}
	
	

}
