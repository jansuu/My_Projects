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

import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.VerificationRequest;
import com.hotelbooking.cozyheaven.service.VerificationRequestService;

@RestController
@RequestMapping("/api/verificationrequest")
public class VerificationRequestController {
	
	  @Autowired
	    private VerificationRequestService verificationRequestService;

	    // ✅ Add a new verification request (linked with owner and hotel)
	    @PostMapping("/add/{ownerId}/{hotelId}")
	    public VerificationRequest addRequest(@PathVariable int ownerId,
	                                          @PathVariable int hotelId,
	                                          @RequestBody VerificationRequest request) throws InvalidIDException {
	        return verificationRequestService.addVerificationRequest(ownerId, hotelId, request);
	    }

	    // ✅ Get a specific verification request by its ID
	    @GetMapping("/get/{id}")
	    public VerificationRequest getRequestById(@PathVariable int id) throws InvalidIDException {
	        return verificationRequestService.getRequestById(id);
	    }

	    // ✅ Get all verification requests by owner and hotel IDs
	    @GetMapping("/getbyownerandhotel/{ownerId}/{hotelId}")
	    public List<VerificationRequest> getRequestsByOwnerAndHotel(@PathVariable int ownerId,
	                                                                @PathVariable int hotelId) throws InvalidIDException {
	        return verificationRequestService.getRequestsByOwnerAndHotel(ownerId, hotelId);
	    }

	    // ✅ Accept a verification request (admin)
	    @PutMapping("/accept/{id}")
	    public VerificationRequest acceptRequest(@PathVariable int id) throws InvalidIDException {
	        return verificationRequestService.acceptRequest(id);
	    }

	    // ✅ Cancel (reject) a verification request (admin)
	    @PutMapping("/cancel/{id}")
	    public VerificationRequest cancelRequest(@PathVariable int id) throws InvalidIDException {
	        return verificationRequestService.cancelRequest(id);
	    }

	    // ✅ View all pending verification requests
	    @GetMapping("/pending")
	    public List<VerificationRequest> getPendingRequests() {
	        return verificationRequestService.getPendingRequests();
	    }

	    // ✅ Update an existing verification request
	    @PutMapping("/update/{id}")
	    public VerificationRequest updateRequest(@PathVariable int id,
	                                             @RequestBody VerificationRequest request) throws InvalidIDException {
	        return verificationRequestService.updateRequestDetails(id, request);
	    }
}
