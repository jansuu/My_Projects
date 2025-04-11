package com.hotelbooking.cozyheaven.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.enums.ApprovalStatus;
import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Hotel;
import com.hotelbooking.cozyheaven.model.HotelOwner;
import com.hotelbooking.cozyheaven.model.VerificationRequest;
import com.hotelbooking.cozyheaven.repository.VerificationRequestRepository;

@Service
public class VerificationRequestService {
	@Autowired
	private VerificationRequestRepository verificationRequestRepository;

	@Autowired
	private HotelOwnerService hotelOwnerService;

	@Autowired
	private HotelService hotelService;

	// Add new verification request
	public VerificationRequest addVerificationRequest(int ownerId, int hotelId, VerificationRequest request)
			throws InvalidIDException {
		HotelOwner owner = hotelOwnerService.getOwnerByID(ownerId);
		Hotel hotel = hotelService.getHotelById(hotelId);

		request.setHotelOwner(owner);
		request.setHotel(hotel);
		request.setStatus(ApprovalStatus.PENDING);

		return verificationRequestRepository.save(request);
	}

	// Get by ID
	public VerificationRequest getRequestById(int id) throws InvalidIDException {
		Optional<VerificationRequest> optional = verificationRequestRepository.findById(id);
		if (optional.isEmpty())
			throw new InvalidIDException("Verification Request ID does not exist!");
		return optional.get();
	}

	// Get all requests by ownerId and hotelId
	public List<VerificationRequest> getRequestsByOwnerAndHotel(int ownerId, int hotelId) throws InvalidIDException {
		HotelOwner owner = hotelOwnerService.getOwnerByID(ownerId);
		Hotel hotel = hotelService.getHotelById(hotelId);
		return verificationRequestRepository.findByHotelOwnerAndHotel(owner, hotel);
	}

	// Accept request
	public VerificationRequest acceptRequest(int id) throws InvalidIDException {
		VerificationRequest request = getRequestById(id);
		request.setStatus(ApprovalStatus.APPROVED);
		return verificationRequestRepository.save(request);
	}

	// Cancel request
	public VerificationRequest cancelRequest(int id) throws InvalidIDException {
		VerificationRequest request = getRequestById(id);
		request.setStatus(ApprovalStatus.CANCELLED);
		return verificationRequestRepository.save(request);
	}

	// Show all pending requests
	public List<VerificationRequest> getPendingRequests() {
		return verificationRequestRepository.findByStatus(ApprovalStatus.PENDING);
	}

	// Update request message, document, and status
	public VerificationRequest updateRequestDetails(int id, VerificationRequest updatedRequest)
			throws InvalidIDException {
		VerificationRequest request = getRequestById(id);

		request.setMessage(updatedRequest.getMessage());
		request.setDocument(updatedRequest.getDocument());
		request.setStatus(updatedRequest.getStatus());

		return verificationRequestRepository.save(request);
	}

}
