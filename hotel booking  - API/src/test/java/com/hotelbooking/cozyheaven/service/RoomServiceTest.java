package com.hotelbooking.cozyheaven.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.hotelbooking.cozyheaven.enums.DeletionRequest;
import com.hotelbooking.cozyheaven.enums.GovernmentIDType;
import com.hotelbooking.cozyheaven.enums.HotelAvailability;
import com.hotelbooking.cozyheaven.enums.HotelStatus;
import com.hotelbooking.cozyheaven.enums.HotelType;
import com.hotelbooking.cozyheaven.enums.IsVerified;
import com.hotelbooking.cozyheaven.enums.RoomAvailabilityStatus;
import com.hotelbooking.cozyheaven.enums.RoomType;
import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Booking;
import com.hotelbooking.cozyheaven.model.Hotel;
import com.hotelbooking.cozyheaven.model.HotelOwner;
import com.hotelbooking.cozyheaven.model.Room;
import com.hotelbooking.cozyheaven.model.User;
import com.hotelbooking.cozyheaven.repository.RoomRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class RoomServiceTest 
{
	@InjectMocks
	private RoomService roomService;
	
	@Mock
	private RoomRepository roomRepository;
	
	Room r1;
	Room r2;
	Hotel h1;
	Hotel h2;
	HotelOwner owner1;
	HotelOwner owner2;
	
	@BeforeEach
	public void init()
	{
		r1 = new Room(1, "Deluxe Sea View", 3500.00, 2, "WiFi, AC, TV", 
				RoomAvailabilityStatus.AVAILABLE, RoomType.DELUXE, "deluxe1.jpg,deluxe2.jpg", h1);

		r2 = new Room(2, "Standard Mountain View", 2000.00, 2, "WiFi, Heater", 
				RoomAvailabilityStatus.NOT_AVAILABLE, RoomType.SINGLE, "standard1.jpg,standard2.jpg", h2);
		
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
		
	}
	
	@Test
	public void addRoom() 
	{
		when(roomRepository.save(r2)).thenReturn(r1);
		assertEquals(r1, roomService.addRoom(r2));
	}
	
	@Test
	public void getAllRooms() 
	{
		List<Room> room = Arrays.asList(r1,r2);
		when(roomRepository.findAll()).thenReturn(room);
		assertEquals(room, roomService.getAllRooms());
	}
	
	@Test
	public void getRoomById() 
	{
		when(roomRepository.findById(r1.getId())).thenReturn(Optional.of(r1));
		try {
			assertEquals(r1, roomService.getRoomById(1));
		} catch (InvalidIDException e) {
			assertEquals("Room  ID Does Not Exist!", e.getMessage());
		}
	}
	
	@Test
	public void getRoomByHotel() throws InvalidIDException 
	{
		List<Room> room = Arrays.asList(r1, r2);
		when(roomRepository.findByHotelId(r1.getId())).thenReturn(room);
		assertEquals(room, roomService.getRoomByHotel(1));
	}

	

}
