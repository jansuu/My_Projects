package com.hotelbooking.cozyheaven.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.cozyheaven.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{

	Optional<Review> findByBookingRoomId(int roomId);

//	Optional<Review> findByCustomerId(int customerId);

}
