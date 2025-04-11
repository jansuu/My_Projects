package com.hotelbooking.cozyheaven.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Hotel;
import com.hotelbooking.cozyheaven.repository.HotelRepository;

@Service
public class HotelService 
{
	@Autowired
	private HotelRepository hotelRepository;

	public Hotel addHotel(Hotel hotel) {
		
		return hotelRepository.save(hotel);
	}

	public List<Hotel> getHotelByOwnerID(int hotelownerID) {
		
		return hotelRepository.findByHotelOwnerId(hotelownerID); 
	}

	public Hotel findByHotelID(int hotelID) throws InvalidIDException {
		 Optional<Hotel> optional = hotelRepository.findById(hotelID);
         if(optional==null)
        	 throw new InvalidIDException("Hotel  ID Does Not Exist!");
         return optional.get();
	}

	public Hotel getHotelById(int hotelId) {
		// TODO Auto-generated method stub
		return null;
	}



	

}
