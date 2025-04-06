package com.hotelbooking.cozyheaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.repository.CancellationRequestRepository;

@Service
public class CancellationRequestService
{
	@Autowired
	private CancellationRequestRepository cancellationRequestRepository; 

}
