package com.hotelbooking.cozyheaven.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.cozyheaven.model.Report.RoomType;
import com.hotelbooking.cozyheaven.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer>  {

	Optional<Room> findByMaxCapacity(int minGuests);

	Optional<Room> findByType(RoomType roomType);

	Optional<Room> findByAvailabilityStatus(String status);

}
