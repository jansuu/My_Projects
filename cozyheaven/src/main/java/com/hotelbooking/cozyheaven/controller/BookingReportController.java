package com.hotelbooking.cozyheaven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.model.BookingReport;
import com.hotelbooking.cozyheaven.service.BookingReportService;

@RestController
@RequestMapping("/api/booking_has_report")
public class BookingReportController {
	
	@Autowired
	private BookingReportService  bookingReportService;
	
	
	@GetMapping("/all")
	public List<BookingReport> getAllBooking()
	{
		return bookingReportService.getAllBooking();
	}
	

}
