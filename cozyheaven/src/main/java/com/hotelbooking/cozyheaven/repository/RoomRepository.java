package com.hotelbooking.cozyheaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.cozyheaven.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer>  {

}
