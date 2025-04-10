package com.hotelbooking.cozyheaven.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.CancellationRequest;
import com.hotelbooking.cozyheaven.model.HotelOwner;
import com.hotelbooking.cozyheaven.repository.CancellationRequestRepository;

@Service
public class CancellationRequestService
{
	@Autowired
	private CancellationRequestRepository cancellationRequestRepository;

	public CancellationRequest cancellBooking(CancellationRequest cancellationRequest) {
		
		return cancellationRequestRepository.save(cancellationRequest);
	}

	public List<CancellationRequest> cancellBookingAll() {
		
		return cancellationRequestRepository.findAll();
	} 
	
	public CancellationRequest findByID(int id) throws InvalidIDException {
		  Optional<CancellationRequest> optional = cancellationRequestRepository.findById(id);
	         if(optional==null)
	        	 throw new InvalidIDException("Hotel Owner ID Does Not Exist!");
	         return optional.get();
	}

}
