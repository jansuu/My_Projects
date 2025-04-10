package com.hotelbooking.cozyheaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.model.OwnerVerificationReq;
import com.hotelbooking.cozyheaven.model.VerificationRequest;
import com.hotelbooking.cozyheaven.repository.OwnerVerficationReqRepository;

@Service
public class OwnerVerficationReqService {
	@Autowired
	private OwnerVerficationReqRepository hotelOwnerHasVerficationRequestRepository;

	public OwnerVerificationReq assignRequest(OwnerVerificationReq assign) {
		
		return hotelOwnerHasVerficationRequestRepository.save(assign);
	}


}
