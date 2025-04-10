package com.hotelbooking.cozyheaven.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.cozyheaven.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	Optional<Booking> findByCustomerId(int userId);

	Optional<Booking> findByRoomId(int roomId);

}
