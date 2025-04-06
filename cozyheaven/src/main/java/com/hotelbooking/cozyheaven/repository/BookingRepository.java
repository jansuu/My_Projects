package com.hotelbooking.cozyheaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.cozyheaven.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
