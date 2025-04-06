package com.hotelbooking.cozyheaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.service.BookingHasReportService;

@RestController
@RequestMapping("/api/booking_has_report")
public class BookingHasReportController {
	
	@Autowired
	private BookingHasReportService  bookingHasReportService;

}
