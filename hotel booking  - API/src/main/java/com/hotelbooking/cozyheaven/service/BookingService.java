package com.hotelbooking.cozyheaven.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.exception.BookingNotFoundException;
import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Booking;
import com.hotelbooking.cozyheaven.model.Customer;
import com.hotelbooking.cozyheaven.repository.BookingRepository;
import com.hotelbooking.cozyheaven.repository.CustomerRepository;

@Service
public class BookingService 
{

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private CustomerRepository customerRepository;


	public Booking createBooking(Booking booking) 
	{
		// TODO Auto-generated method stub
		return bookingRepository.save(booking);
	}
	
	public List<Booking> getBookingsByCustomer(int customerId) throws InvalidIDException 
	{
		// TODO Auto-generated method stub
		List<Booking> booking = bookingRepository.findByCustomerId(customerId);
		if(booking.isEmpty())
		{
			throw new InvalidIDException("customer ID is invalid...");
		}
		return booking;
	}

	
	
	
	

	public Booking getBookingById(int bookingId) throws InvalidIDException {
		// TODO Auto-generated method stub
		Optional<Booking> optional = bookingRepository.findById(bookingId);
		if(optional.isEmpty())
		{
			throw new InvalidIDException("booking ID is invalid...");
		}
		return optional.get();
	}

	public List<Booking> getBookingsByRoom(int roomId) throws InvalidIDException 
	{
		// TODO Auto-generated method stub
		List<Booking> booking = bookingRepository.findByRoomId(roomId);
		if(booking.isEmpty())
		{
			throw new InvalidIDException("room ID is invalid...");
		}
		return booking;
	}

	public void cancelBooking(int bookingId) 
	{
		// TODO Auto-generated method stub
		bookingRepository.deleteById(bookingId);
	}

	public List<Booking> getAllBooking() {
		// TODO Auto-generated method stub
		return bookingRepository.findAll();
	}

	
	// created By Dinesh
	public List<Booking> getBookingByHotelID(int hotelid) {
		
		List<Booking> bookings = bookingRepository.findByRoomHotelId(hotelid);
		return bookings;
	}

	public List<Booking> getBookingByOwner(int ownerid) {
		
		return bookingRepository.findByRoomHotelHotelOwnerId(ownerid);
	}

	public List<Booking> getBookingByPlace(String location) 
	{
		return bookingRepository.findByRoomHotelCity(location);
	}

	public long getCountOfBooking() 
	{
		return bookingRepository.count();
	}

	public List<Booking> getListOfBookingByDate(LocalDateTime bookdate) 
	{
		return bookingRepository.findByBookedAt(bookdate);
	}
	
	public long getListOfBookingByDateCount(LocalDateTime bookdate) 
	{
		List<Booking> book = bookingRepository.findByBookedAt(bookdate);
		return book.size();
	}

	public List<Booking> getListofBookingByCustom(LocalDateTime fromdate, LocalDateTime todate) throws BookingNotFoundException 
	{
		List<Booking> bookings = bookingRepository.findByBookedAtBetween(fromdate,todate);
		if(bookings.isEmpty())
			throw new BookingNotFoundException("No Records Found between these dates");
			
		return bookings;
	}

	public Booking updateBooking(Booking booking) 
	{
		// TODO Auto-generated method stub
		return bookingRepository.save(booking);
		
	}
	
	public List<Booking> getBookingsByUsername(String username) throws InvalidIDException 
	{
	    Customer customer = customerRepository.findByEmail(username)
	        .orElseThrow(() -> new InvalidIDException("Customer not found"));

	    List<Booking> bookings = bookingRepository.findByCustomerId(customer.getId());
	    if (bookings.isEmpty()) {
	        throw new InvalidIDException("No bookings found for this customer");
	    }
	    return bookings;
	}

	

}
