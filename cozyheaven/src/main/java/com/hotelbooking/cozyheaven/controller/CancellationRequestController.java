package com.hotelbooking.cozyheaven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.enums.Status;
import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Booking;
import com.hotelbooking.cozyheaven.model.CancellationRequest;
import com.hotelbooking.cozyheaven.service.BookingService;
import com.hotelbooking.cozyheaven.service.CancellationRequestService;

@RestController
@RequestMapping("/api/cancellationrequest")
public class CancellationRequestController {
	@Autowired
	private CancellationRequestService cancellationRequestService;
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/add/{bookingID}")
	public CancellationRequest cancellBooking(@PathVariable int bookingID,@RequestBody CancellationRequest cancellationRequest) throws InvalidIDException {
		Booking booking=bookingService.getBookingById(bookingID);
		cancellationRequest.setBooking(booking);
		return cancellationRequestService.cancellBooking(cancellationRequest);
		
	}
	
	// To Get All Cancellation Request
	@GetMapping("/getall")
	public List<CancellationRequest> cancellBookingAll() {
		return cancellationRequestService.cancellBookingAll();
		
	}
	
	// To Accept or Reject Cancellation Request 
	@PostMapping("accept/reject/{cancellationID}")
	public CancellationRequest acceptCancellation(@PathVariable int cancellationID,@RequestParam Status status) throws InvalidIDException {
		CancellationRequest request = cancellationRequestService.findByID(cancellationID);
		request.setStatus(status);
		return cancellationRequestService.cancellBooking(request);
	}
	

}
