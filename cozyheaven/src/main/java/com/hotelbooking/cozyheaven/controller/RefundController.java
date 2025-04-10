package com.hotelbooking.cozyheaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.CancellationRequest;
import com.hotelbooking.cozyheaven.model.Refund;
import com.hotelbooking.cozyheaven.service.CancellationRequestService;
import com.hotelbooking.cozyheaven.service.RefundService;

@RestController
@RequestMapping("/api/refund")
public class RefundController {

   
	@Autowired
	private RefundService refundService;
	@Autowired
	private CancellationRequestService cancellationRequestService;
	
	@PostMapping("/proceed/{cancellationID}")
    public Refund postRefund(@PathVariable int cncellationID,@RequestBody Refund refund) throws InvalidIDException {
		
		CancellationRequest request=  cancellationRequestService.findByID(cncellationID);
		refund.setCancellationRequest(request);
		return refundService.postRefund(refund);
		
		
	}
	

}

















