package com.hotelbooking.cozyheaven.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.hotelbooking.cozyheaven.enums.BookingStatus;
import com.hotelbooking.cozyheaven.enums.DeletionRequest;
import com.hotelbooking.cozyheaven.enums.GovernmentIDType;
import com.hotelbooking.cozyheaven.enums.HotelAvailability;
import com.hotelbooking.cozyheaven.enums.HotelStatus;
import com.hotelbooking.cozyheaven.enums.HotelType;
import com.hotelbooking.cozyheaven.enums.IsVerified;
import com.hotelbooking.cozyheaven.enums.PaymentMethod;
import com.hotelbooking.cozyheaven.enums.PaymentStatus;
import com.hotelbooking.cozyheaven.enums.RoomAvailabilityStatus;
import com.hotelbooking.cozyheaven.enums.RoomType;
import com.hotelbooking.cozyheaven.model.Booking;
import com.hotelbooking.cozyheaven.model.Customer;
import com.hotelbooking.cozyheaven.model.Hotel;
import com.hotelbooking.cozyheaven.model.HotelOwner;
import com.hotelbooking.cozyheaven.model.Payment;
import com.hotelbooking.cozyheaven.model.Room;
import com.hotelbooking.cozyheaven.model.User;
import com.hotelbooking.cozyheaven.repository.PaymentRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest 
{
	@InjectMocks
	private PaymentService paymentService;
	
	@Mock
	private PaymentRepository paymentRepository;
	
	Customer c1;
	Room r1;
	Room r2;
	Booking b1;
	Booking b2;
	Hotel h1;
	Hotel h2;
	HotelOwner owner1;
	HotelOwner owner2;
	Payment p1;
	Payment p2;

	@BeforeEach
	public void init() 
	{

		c1 = new Customer(1, "John Doe", "john@example.com", "456 Elm Street, Delhi", "9876543219",
				LocalDate.now().minusYears(1),new User(3, "johnuser", "john@example.com", "securepass", "Customer"));

		r1 = new Room(1, "Deluxe Room", 2500.0, 3, "WiFi, AC, TV", RoomAvailabilityStatus.AVAILABLE,
				RoomType.DELUXE, "deluxe1.jpg,deluxe2.jpg", h1);

		r2 = new Room(2, "Standard Room", 1500.0, 2, "Fan, TV", RoomAvailabilityStatus.NOT_AVAILABLE,
				RoomType.DOUBLE, "standard1.jpg,standard2.jpg", h2);

		b1 = new Booking(1, LocalDate.now().plusDays(1), LocalDate.now().plusDays(5), 2, 10000.0,
				BookingStatus.CONFIRMED, LocalDateTime.now(), c1, r1);

		b2 = new Booking(2, LocalDate.now().plusDays(3), LocalDate.now().plusDays(6), 1, 4500.0,
				BookingStatus.CANCELLED, LocalDateTime.now().minusDays(2), c1, r2);
		
		owner1 = new HotelOwner(1, "Owner One", "owner1@example.com", "9876543210", "123 Main Street, Delhi",
				GovernmentIDType.AadharCard, "AADHAAR123456", "BRN001", "GSTIN001", "BANK001", IsVerified.Verified,
				LocalDateTime.now().minusDays(20),
				new User(1, "owner1", "owner1user@example.com", "pass1", "HotelOwner"));

		owner2 = new HotelOwner(1, "Owner Two", "owner2@example.com", "9876543210", "123 Main Street, Delhi",
				GovernmentIDType.AadharCard, "AADHAAR123456", "BRN001", "GSTIN001", "BANK001", IsVerified.NotVerified,
				LocalDateTime.now().minusDays(20),
				new User(2, "owner2", "owner2user@example.com", "pass2", "HotelOwner"));

		h1 = new Hotel(1, "Hotel Sunshine", HotelType.BUDGET, "Beachside resort", "123 Beach Road", "Goa", "Goa",
				"403001", "India", "contact@sunshine.com", "9876543210", "sunshine.jpg", HotelStatus.APPROVED,
				HotelAvailability.YES, "Pool, Spa, Gym", "LIC12345", "PROP56789", 4.5,
				LocalDateTime.now().minusDays(10), LocalDateTime.now().minusDays(5), DeletionRequest.Yes, owner1);

		h2 = new Hotel(2, "Mountain View", HotelType.HOSTEL, "Hilltop hotel", "456 Hill Street", "Manali",
				"Himachal Pradesh", "175131", "India", "contact@mountainview.com", "9876543211", "mountain.jpg",
				HotelStatus.PENDING, HotelAvailability.YES, "WiFi, Breakfast", "LIC54321", "PROP12345", 3.8,
				LocalDateTime.now().minusDays(20), null, DeletionRequest.No, owner2);
		
		p1 = new Payment(1, 5000.0, 10000.0, LocalDateTime.now(), PaymentMethod.CREDIT, PaymentStatus.COMPLETED, b1);
		
	    p2 = new Payment(2, 2500.0, 5000.0, LocalDateTime.now(), PaymentMethod.DEBIT, PaymentStatus.PENDING, b2);
	}
	
	@Test
	public void makePayment() 
	{
		when(paymentRepository.save(p2)).thenReturn(p1);
		assertEquals(p1, paymentService.makePayment(p2));
	}
	
	

}
