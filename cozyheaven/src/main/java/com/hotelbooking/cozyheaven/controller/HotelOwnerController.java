package com.hotelbooking.cozyheaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.HotelOwner;
import com.hotelbooking.cozyheaven.model.User;
import com.hotelbooking.cozyheaven.service.AuthService;
import com.hotelbooking.cozyheaven.service.HotelOwnerService;

@RestController
@RequestMapping("/api/hotelowner")
public class HotelOwnerController {
	@Autowired
	private HotelOwnerService hotelOwnerService;
	@Autowired
	private AuthService authService;

	// To Add Hotel Owner
	@PostMapping("/add/{userid}")
	public HotelOwner addHotelOwner(@RequestBody HotelOwner hotelOwner,@PathVariable int userid) throws InvalidIDException {
		
		User user=authService.getUserById(userid);
		hotelOwner.setUser(user);
		return hotelOwnerService.addHotelOwner(hotelOwner);

	}

	// To Get Owner Details
	@GetMapping("/get/{ownerid}")
	public HotelOwner getOwnerByID(@PathVariable int ownerid) throws InvalidIDException {
		return hotelOwnerService.getOwnerByID(ownerid);
	}

	// To Update Owner Info
	@PutMapping("/update/{ownerid}")
	public HotelOwner updateInfo(@PathVariable int ownerid, @RequestBody HotelOwner request)throws InvalidIDException {
		HotelOwner hotelOwner = hotelOwnerService.getOwnerByID(ownerid);
		if (request.getName() != null) {
	        hotelOwner.setName(request.getName());
	    }
	    if (request.getEmail() != null) {
	        hotelOwner.setEmail(request.getEmail());
	    }
	    if (request.getContact() != null) {
	        hotelOwner.setContact(request.getContact());
	    }
	    if (request.getAddress() != null) {
	        hotelOwner.setAddress(request.getAddress());
	    }
	    if (request.getGovernmenttIDType() != null) {
	        hotelOwner.setGovernmenttIDType(request.getGovernmenttIDType());
	    }
	    if (request.getGovernmentIDNumber() != null) {
	        hotelOwner.setGovernmentIDNumber(request.getGovernmentIDNumber());
	    }
	    if (request.getBuisnessRegistrationNumber() != null) {
	        hotelOwner.setBuisnessRegistrationNumber(request.getBuisnessRegistrationNumber());
	    }
	    if (request.getGstin() != null) {
	        hotelOwner.setGstin(request.getGstin());
	    }
	    if (request.getBankDetails() != null) {
	        hotelOwner.setBankDetails(request.getBankDetails());
	    }
		return hotelOwnerService.addHotelOwner(hotelOwner);

	}

}
