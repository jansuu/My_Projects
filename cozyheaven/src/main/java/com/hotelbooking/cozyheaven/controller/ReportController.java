package com.hotelbooking.cozyheaven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.model.Booking;
import com.hotelbooking.cozyheaven.service.ReportService;

@RestController
@RequestMapping("/api/report")
public class ReportController {

	@Autowired
	private ReportService reportService;
	
	/*LIST OF HOTELS*/
	// --by location
	// --by season
	
	/*Fetch the Bookings of Date of Booking basis,*/
	
	@GetMapping("/getall-booking")
	public List<Booking> getAllBooking()
	{
		return reportService.getAllBooking();
	}

}
