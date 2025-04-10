package com.hotelbooking.cozyheaven.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Booking;
import com.hotelbooking.cozyheaven.model.Payment;
import com.hotelbooking.cozyheaven.model.Payment.PaymentStatus;
import com.hotelbooking.cozyheaven.model.Review;
import com.hotelbooking.cozyheaven.service.BookingService;
import com.hotelbooking.cozyheaven.service.PaymentService;

import io.jsonwebtoken.lang.Collections;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/add/{bid}")
	public Payment makePayment(@PathVariable int bid, @RequestBody Payment payment) throws InvalidIDException
	{
		Booking booking =  bookingService.getBookingById(bid);
		
		payment.setBooking(booking);
		payment = paymentService.makePayment(payment);
		return payment;
	}

	    // Get payment by ID
	    @GetMapping("/{paymentId}")
	    public Payment getPaymentById(@PathVariable int paymentId) throws InvalidIDException 
	    {
	        return paymentService.getPaymentById(paymentId);
	    }

	    // Get payments by booking
	    @GetMapping("/booking/{bookingId}")
	    public Payment getPaymentsByBooking(@PathVariable int bookingId) throws InvalidIDException 
	    {
	        return paymentService.getPaymentsByBookingId(bookingId);
	    }

//	    // Get payments by customer
//	    @GetMapping("/customer/{customerId}")
//	    public Payment getPaymentsByCustomer(@PathVariable int customerId) throws InvalidIDException
//	    {
//	        return paymentService.getPaymentsByCustomerId(customerId);
//	    }

	    @GetMapping("/{paymentId}/status")
	    public PaymentStatus getPaymentStatus(@PathVariable int paymentId) throws InvalidIDException 
	    {
	    	Payment payment=paymentService.getPaymentStatus(paymentId);
	    	return payment.getStatus();
	    }
	    
	 // update payment status
	    @GetMapping("update/{paymentId}/status")
	    public Payment updatePaymentStatus(@PathVariable int paymentId,@RequestBody Payment newValue) throws InvalidIDException 
	    {
	    	Payment payment = paymentService.getPaymentById(paymentId);
	    	if(newValue.getStatus() != null)
	    		payment.setStatus(newValue.getStatus());
	    	return paymentService.updatePaymentStatus(payment);
	    }



}
