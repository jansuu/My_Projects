package com.hotelbooking.cozyheaven.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.enums.Status;
import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Booking;
import com.hotelbooking.cozyheaven.model.CancellationRequest;
import com.hotelbooking.cozyheaven.model.HotelOwner;
import com.hotelbooking.cozyheaven.repository.CancellationRequestRepository;

@Service
public class CancellationRequestService {
	@Autowired
	private CancellationRequestRepository cancellationRequestRepository;

	// To Save Requests in DB
	public CancellationRequest cancellBooking(CancellationRequest cancellationRequest) {

		return cancellationRequestRepository.save(cancellationRequest);
	}

	// To Get All Requests
	public List<CancellationRequest> cancellBookingAll() {

		return cancellationRequestRepository.findAll();
	}

	//To Get Request By ID
	public CancellationRequest findByID(int id) throws InvalidIDException {
		Optional<CancellationRequest> optional = cancellationRequestRepository.findById(id);
		if (optional.isEmpty())
			throw new InvalidIDException("Cancellation ID Does Not Exist!");
		return optional.get();
	}
	
    // To Get Request By Hotel
	public List<CancellationRequest> getByHotel(int hotelid) {

		return cancellationRequestRepository.findByBookingRoomHotelId(hotelid);
	}

	// To Get Request By Status
	public List<CancellationRequest> getByApproval() {

		return cancellationRequestRepository.findByStatus(Status.APPROVED);
	}

	// To Get Request By Status
	public List<CancellationRequest> getByRejections() {

		return cancellationRequestRepository.findByStatus(Status.REJECTED);
	}

}
