package com.hotelbooking.cozyheaven.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.enums.DeletionRequest;
import com.hotelbooking.cozyheaven.enums.HotelStatus;
import com.hotelbooking.cozyheaven.enums.Status;
import com.hotelbooking.cozyheaven.exception.InvalidHotelNameException;
import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Hotel;
import com.hotelbooking.cozyheaven.repository.HotelRepository;

@Service
public class HotelService {
	@Autowired
	private HotelRepository hotelRepository;

	// To Save Hotel in DB
	public Hotel addHotel(Hotel hotel) {

		return hotelRepository.save(hotel);
	}

	// Get All Hotels With Owner Id
	public List<Hotel> getHotelByOwnerID(int hotelownerID) {

		return hotelRepository.findByHotelOwnerId(hotelownerID);
	}

	// Get Hotel By Id
	public Hotel findByHotelID(int hotelID) throws InvalidIDException {
		Optional<Hotel> optional = hotelRepository.findById(hotelID);
		if (optional.isEmpty())
			throw new InvalidIDException("Hotel  ID Does Not Exist!");
		return optional.get();
	}

	// To Get Pending Requests Of Hotel Verification
	public List<Hotel> getPendingRequests() {

		return hotelRepository.findByStatus(HotelStatus.PENDING);
	}

	// Get Hotel By Name
	public List<Hotel> getByHotelName(String name) throws InvalidHotelNameException {

		List<Hotel> hotels = hotelRepository.findByName(name);
		if (hotels.isEmpty())
			throw new InvalidHotelNameException("Hotel Name Not Found!");
		return hotels;
	}

	// To Get Approved Hotels
	public List<Hotel> getHotelByApproval() {

		return hotelRepository.findByStatus(HotelStatus.APPROVED);
	}

	// To Get Deletion Requested Hotel
	public List<Hotel> getDeletionRequests() {

		return hotelRepository.findByDeletionRequested(DeletionRequest.Yes);
	}

}
