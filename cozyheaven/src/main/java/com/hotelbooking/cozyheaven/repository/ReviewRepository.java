package com.hotelbooking.cozyheaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.cozyheaven.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{

}
