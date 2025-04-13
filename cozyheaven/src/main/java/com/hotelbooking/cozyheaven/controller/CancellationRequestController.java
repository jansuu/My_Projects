package com.hotelbooking.cozyheaven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.enums.Status;
import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Booking;
import com.hotelbooking.cozyheaven.model.CancellationRequest;
import com.hotelbooking.cozyheaven.model.Hotel;
import com.hotelbooking.cozyheaven.service.BookingService;
import com.hotelbooking.cozyheaven.service.CancellationRequestService;
import com.hotelbooking.cozyheaven.service.HotelService;

@RestController
@RequestMapping("/api/cancellationrequest")
public class CancellationRequestController {
	@Autowired
	private CancellationRequestService cancellationRequestService;
	@Autowired
	private BookingService bookingService;
	@Autowired
	private HotelService hotelService;

	//To Make CancellationRequest
	@PostMapping("/add/{bookingID}")
	public CancellationRequest cancellBooking(@PathVariable int bookingID,@RequestBody CancellationRequest cancellationRequest) throws InvalidIDException {
		Booking booking = bookingService.getBookingById(bookingID);
		cancellationRequest.setBooking(booking);
		return cancellationRequestService.cancellBooking(cancellationRequest);

	}

	// To Get All Cancellation Request
	@GetMapping("/getall")
	public List<CancellationRequest> cancellBookingAll() {
		return cancellationRequestService.cancellBookingAll();

	}

	// to get cancellation request by specific hotel
	@GetMapping("/getbyhotel/{hotelid}")
	public List<CancellationRequest> getByHotel(@PathVariable int hotelid) throws InvalidIDException {
		Hotel hotel = hotelService.findByHotelID(hotelid);
		return cancellationRequestService.getByHotel(hotelid);

	}

	// to get request by status
	@GetMapping("/getbyapproved")
	public List<CancellationRequest> getByApproval() {
		return cancellationRequestService.getByApproval();
	}

	// to get request by status
	@GetMapping("/getbyrejected")
	public List<CancellationRequest> getByRejections() {
		return cancellationRequestService.getByRejections();
	}

	// To Accept Cancellation Request
	@PutMapping("accept/{cancellationID}")
	public CancellationRequest acceptCancellation(@PathVariable int cancellationID) throws InvalidIDException {
		CancellationRequest request = cancellationRequestService.findByID(cancellationID);
		request.setStatus(Status.APPROVED);
		return cancellationRequestService.cancellBooking(request);
	}

	// To Reject Cancellation Request
	@PutMapping("reject/{cancellationID}")
	public CancellationRequest rejectCancellation(@PathVariable int cancellationID) throws InvalidIDException {
		CancellationRequest request = cancellationRequestService.findByID(cancellationID);
		request.setStatus(Status.REJECTED);
		return cancellationRequestService.cancellBooking(request);
	}

}
