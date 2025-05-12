package com.hotelbooking.cozyheaven.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.enums.RoomType;
import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Room;
import com.hotelbooking.cozyheaven.repository.RoomRepository;

@Service
public class RoomService 
{
	@Autowired
	private RoomRepository roomRepository;

	public List<Room> getAllRooms() 
	{
		// TODO Auto-generated method stub
		return roomRepository.findAll();
	}

	public Room getRoomById(int roomId) throws InvalidIDException 
	{
		// TODO Auto-generated method stub
		Optional<Room> optional = roomRepository.findById(roomId);
		if(optional.isEmpty())
		{
			throw new InvalidIDException("room ID is invalid...");
		}
		return optional.get();
	}

	public Room addRoom(Room room) {
		// TODO Auto-generated method stub
		return roomRepository.save(room);
	}

	public List<Room> getRoomByHotel(int hid) 
	{
		// TODO Auto-generated method stub
		return roomRepository.findByHotelId(hid);
	}

	public Room updateRoom(Room room) 
	{
		// TODO Auto-generated method stub
		return roomRepository.save(room);
	}

}
