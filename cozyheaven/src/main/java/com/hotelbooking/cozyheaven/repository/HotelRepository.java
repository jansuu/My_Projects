package com.hotelbooking.cozyheaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.cozyheaven.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

}
