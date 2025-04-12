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
	  
		/*
		 * The Hotel Owner can give a Verification request to the admin by means of
		 * giving onwerId, hotelId and additionally hotelID is included because it shows
		 * that this owner has this hotel and can be viewed by the admin
		 */
	    @PostMapping("/add/{ownerId}/{hotelId}")
	    public VerificationRequest addRequest(@PathVariable int ownerId,
	                                          @PathVariable int hotelId,
	                                          @RequestBody VerificationRequest request) throws InvalidIDException {
	        return verificationRequestService.addVerificationRequest(ownerId, hotelId, request);
	    }
    
	    // This api helps to get a specific verification request by its ID
	    @GetMapping("/get/{id}")
	    public VerificationRequest getRequestById(@PathVariable int id) throws InvalidIDException {
	        return verificationRequestService.getRequestById(id);
	    }

	    // It helps to get all verification requests by owner and hotel IDs like it shows the owner and hotel which the owner have
	    @GetMapping("/getbyownerandhotel/{ownerId}/{hotelId}")
	    public List<VerificationRequest> getRequestsByOwnerAndHotel(@PathVariable int ownerId,
	                                                                @PathVariable int hotelId) throws InvalidIDException {
	        return verificationRequestService.getRequestsByOwnerAndHotel(ownerId, hotelId);
	    }

	    // Basically the admin can see the list of requests so that he can easily verify and accept which one is the right thing!!
	    @PutMapping("/accept/{id}")
	    public VerificationRequest acceptRequest(@PathVariable int id) throws InvalidIDException {
	        return verificationRequestService.acceptRequest(id);
	    }

	    // Similar to the above that the admin can easily cancel the request which it doesn't meet the requirement 
	    @PutMapping("/cancel/{id}")
	    public VerificationRequest cancelRequest(@PathVariable int id) throws InvalidIDException {
	        return verificationRequestService.cancelRequest(id);
	    }

	    // First of all the admin can see these kind of verification list and by seeing the status the admin an easily validate 
	    @GetMapping("/pending")
	    public List<VerificationRequest> getPendingRequests() {
	        return verificationRequestService.getPendingRequests();
	    }
	    
	    // The hotel owner needs to change some of the info for the verification request then the onwer can be easily change by means of this api 
	    @PutMapping("/update/by-owner/{ownerId}")
	    public VerificationRequest updateByOwner(@PathVariable int ownerId,
	                                             @RequestBody VerificationRequest updatedRequest) throws InvalidIDException {
	        return verificationRequestService.updateRequestByOwner(ownerId, updatedRequest);
	    }

	    
	    // finally the hotel owner can see his status of verification request by his owner portel viewing 
	    @GetMapping("/status/{ownerId}")
	    public List<VerificationRequest> getRequestsByOwner(@PathVariable int ownerId) throws InvalidIDException {
	        return verificationRequestService.getRequestsByOwnerId(ownerId);
	    }
	    
	    //need to check the verification api's in the postman
}
