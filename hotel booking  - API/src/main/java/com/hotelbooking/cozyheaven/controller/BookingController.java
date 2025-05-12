package com.hotelbooking.cozyheaven.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Booking;
import com.hotelbooking.cozyheaven.model.Customer;
import com.hotelbooking.cozyheaven.model.Room;
import com.hotelbooking.cozyheaven.service.BookingService;
import com.hotelbooking.cozyheaven.service.CustomerService;
import com.hotelbooking.cozyheaven.service.RoomService;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
	@Autowired
	private BookingService bookingService;
	@Autowired
	private RoomService roomService;
	@Autowired
	private CustomerService customerService;
	
	 // Create a new booking
	@PostMapping("/add/{rid}/{cid}")
	public Booking postBooking(@PathVariable int rid, @PathVariable int cid, @RequestBody Booking booking) throws InvalidIDException
	{
		Customer customers = customerService.getCustomerById(cid);
		Room room =  roomService.getRoomById(rid);
		
		booking.setCustomer(customers);
		booking.setRoom(room);
		booking.setBookedAt(LocalDateTime.now());
		booking = bookingService.createBooking(booking);
		
		return booking;
	}
	
    // Get bookings by customer ID
    @GetMapping("/customer/{customerId}")
    public List<Booking> getBookingsByCustomer(@PathVariable int customerId) throws InvalidIDException 
    {
        return bookingService.getBookingsByCustomer(customerId);
    }
    
    
    
    
    // Get booking by ID
    @GetMapping("/{bookingId}")
    public Booking getBookingById(@PathVariable int bookingId) throws InvalidIDException {
            return bookingService.getBookingById(bookingId);
    }
    
    // Get bookings by room ID
    @GetMapping("/room/{roomId}")
    public List<Booking> getBookingsByRoom(@PathVariable int roomId) throws InvalidIDException {
        return bookingService.getBookingsByRoom(roomId);
    }
    
    // Cancel a booking
    @DeleteMapping("/{bookingId}")
    public void cancelBooking(@PathVariable int bookingId) 
    {
            bookingService.cancelBooking(bookingId);
    }

}
