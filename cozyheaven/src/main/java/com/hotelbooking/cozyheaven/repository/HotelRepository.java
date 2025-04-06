package com.hotelbooking.cozyheaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.cozyheaven.controller.HotelController;

public interface HotelRepository extends JpaRepository<HotelController, Integer> {

}
