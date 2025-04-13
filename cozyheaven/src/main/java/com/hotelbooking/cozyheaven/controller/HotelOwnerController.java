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
import com.hotelbooking.cozyheaven.service.HotelOwnerService;

@RestController
@RequestMapping("/api/hotelowner")
public class HotelOwnerController {
	@Autowired
	private HotelOwnerService hotelOwnerService;

	// To Add Hotel Owner
	@PostMapping("/add")
	public HotelOwner addHotelOwner(@RequestBody HotelOwner hotelOwner) {

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
		hotelOwner.setName(request.getName());
		hotelOwner.setEmail(request.getEmail());
		hotelOwner.setContact(request.getContact());
		hotelOwner.setAddress(request.getAddress());
		hotelOwner.setGovernmenttIDType(request.getGovernmenttIDType());
		hotelOwner.setGovernmentIDNumber(request.getGovernmentIDNumber());
		hotelOwner.setBuisnessRegistrationNumber(request.getBuisnessRegistrationNumber());
		hotelOwner.setGstin(request.getGstin());
		hotelOwner.setBankDetails(request.getBankDetails());
		return hotelOwnerService.addHotelOwner(hotelOwner);

	}

}
