package com.hotelbooking.cozyheaven.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.cozyheaven.enums.RoomType;
import com.hotelbooking.cozyheaven.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer>  {

	List<Room> findByHotelId(int hid);

}
