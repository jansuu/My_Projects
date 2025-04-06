package com.hotelbooking.cozyheaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.service.HotelOwnerHasVerficationRequestService;

@RestController
@RequestMapping("/api/hotelowner_has_verificationrequest")
public class HotelOwnerHasVerficationRequestController {
	
	@Autowired
	private HotelOwnerHasVerficationRequestService hotelOwnerHasVerficationRequestService;

}
