package com.hotelbooking.cozyheaven.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.cozyheaven.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	List<Booking> findByCustomerId(int customerId);

	List<Booking> findByRoomId(int roomId);
	
	List<Booking> findByRoomHotelId(int hotelid);
	
	List<Booking> findByRoomHotelHotelOwnerId(int ownerid);

	List<Booking> findByBookedAt(LocalDateTime bookdate);

	List<Booking> findByRoomHotelCity(String location);

	List<Booking> findByBookedAtBetween(LocalDateTime fromdate, LocalDateTime todate);

}
