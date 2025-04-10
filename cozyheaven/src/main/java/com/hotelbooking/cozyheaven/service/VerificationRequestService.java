package com.hotelbooking.cozyheaven.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.HotelOwner;
import com.hotelbooking.cozyheaven.model.VerificationRequest;
import com.hotelbooking.cozyheaven.repository.VerificationRequestRepository;

@Service
public class VerificationRequestService {
	@Autowired
	private VerificationRequestRepository verificationRequestRepository;

	public  VerificationRequest sendRequest(VerificationRequest request) {
		
		return verificationRequestRepository.save(request);
	}
	
	public VerificationRequest findByID(int id) throws InvalidIDException {
		 Optional<VerificationRequest> optional = verificationRequestRepository.findById(id);
         if(optional==null)
        	 throw new InvalidIDException("Verification ID Does Not Exist!");
         return optional.get();
	}

}
