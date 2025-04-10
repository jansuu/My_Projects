package com.hotelbooking.cozyheaven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Hotel;
import com.hotelbooking.cozyheaven.model.Hotel.DeletionRequest;
import com.hotelbooking.cozyheaven.model.HotelOwner;
import com.hotelbooking.cozyheaven.service.HotelOwnerService;
import com.hotelbooking.cozyheaven.service.HotelService;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
	@Autowired
	private HotelService hotelService;
	@Autowired
	private HotelOwnerService hotelOwnerService;
	
	
	// Adding Hotel With Owner ID
	
	@PostMapping("/add/{hotelownerID}")
	public Hotel addHotel(@PathVariable int hotelownerID,@RequestBody Hotel hotel) throws InvalidIDException {
		
		HotelOwner owner=hotelOwnerService.getOwnerByID(hotelownerID);
		hotel.setHotelOwner(owner);
		return hotelService.addHotel(hotel);
		
	
		
	}
	
	//Get Hotels With Owner Id
	
	@GetMapping("/get/{hotelownerID}")
	public List<Hotel> getHotelByOwnerID(@PathVariable int hotelownerID) throws InvalidIDException {
		HotelOwner owner=hotelOwnerService.getOwnerByID(hotelownerID);
		return hotelService.getHotelByOwnerID(hotelownerID);
		
	}
	
	// Edit Hotel Details  -- need to confirm owning status
	
	@PutMapping("/update/{hotelID}/{hotelownerID}")
	public Hotel updateHotel(@PathVariable int hotelID,@PathVariable int hotelownerID,@RequestBody Hotel hotel) throws InvalidIDException {
		
		HotelOwner owner=hotelOwnerService.getOwnerByID(hotelownerID);
		   
        Hotel hotelsFind=hotelService.findByHotelID(hotelID);
        
        System.out.println(hotelsFind.toString());
		
		hotelsFind.setIsAvailable(hotel.getIsAvailable());
		return hotelService.addHotel(hotelsFind);
	
		
	}
	
	//Delete Request For Hotel
   @DeleteMapping("deleterequest/{hotelID}/{hotelownerID}")
   public Hotel deleteHotel(@PathVariable int hotelID,@PathVariable int hotelownerID,@RequestParam DeletionRequest status) throws InvalidIDException {
		
		HotelOwner owner=hotelOwnerService.getOwnerByID(hotelownerID);
		   
        Hotel hotel=hotelService.findByHotelID(hotelID);
		
		hotel.setDeletionRequested(status);
		return hotelService.addHotel(hotel);
	
		
	}
   

}
















