package com.hotelbooking.cozyheaven.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.enums.BookingStatus;
import com.hotelbooking.cozyheaven.enums.PaymentStatus;
import com.hotelbooking.cozyheaven.enums.RoomAvailabilityStatus;
import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Booking;
import com.hotelbooking.cozyheaven.model.Payment;
import com.hotelbooking.cozyheaven.model.Room;
import com.hotelbooking.cozyheaven.service.BookingService;
import com.hotelbooking.cozyheaven.service.PaymentService;
import com.hotelbooking.cozyheaven.service.RoomService;

@RestController
@RequestMapping("/api/payment")
public class PaymentController 
{
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private BookingService bookingService;
	@Autowired
	private RoomService roomService;
	Logger logger = LoggerFactory.getLogger("PaymentController");
	
	@PostMapping("/add/{bid}")
	public Payment makePayment(@PathVariable int bid, @RequestBody Payment payment) throws InvalidIDException
	{
		logger.info("Initiating payment for booking ID: {}", bid);
		Booking booking =  bookingService.getBookingById(bid);
		if (booking == null) 
		{
		     throw new InvalidIDException("Booking not found for ID: " + bid);
		}
		
		payment.setBooking(booking);
		payment.setPaymentDate(LocalDateTime.now());
		payment = paymentService.makePayment(payment);
		if (payment.getStatus() == PaymentStatus.COMPLETED) 
		{
		        booking.setStatus(BookingStatus.CONFIRMED);  
		        bookingService.updateBooking(booking);
		        logger.info("Booking status updated to CONFIRMED for booking ID: {}", bid);
		        
		        Room room = booking.getRoom();
		        room.setAvailabilityStatus(RoomAvailabilityStatus.NOT_AVAILABLE);
		        roomService.updateRoom(room);
		        logger.info("Room ID: {} marked as NOT_AVAILABLE", room.getId());
		}
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
