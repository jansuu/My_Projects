package com.hotelbooking.cozyheaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.repository.VerificationRequestRepository;

@Service
public class VerificationRequestService {
	@Autowired
	private VerificationRequestRepository verificationRequestRepository;

}
