package com.hotelbooking.cozyheaven.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.cozyheaven.enums.Status;
import com.hotelbooking.cozyheaven.model.CancellationRequest;


public interface CancellationRequestRepository extends JpaRepository<CancellationRequest, Integer> {
	
	List<CancellationRequest> findByBookingRoomHotelId(int hotelid);

	List<CancellationRequest> findByStatus(Status status);

}
