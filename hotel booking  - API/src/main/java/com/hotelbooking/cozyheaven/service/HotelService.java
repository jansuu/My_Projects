package com.hotelbooking.cozyheaven.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hotelbooking.cozyheaven.enums.DeletionRequest;
import com.hotelbooking.cozyheaven.enums.HotelStatus;
import com.hotelbooking.cozyheaven.exception.InvalidAnyException;
import com.hotelbooking.cozyheaven.exception.InvalidHotelNameException;
import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Hotel;
import com.hotelbooking.cozyheaven.repository.HotelRepository;

@Service
public class HotelService 
{
	@Autowired
	private HotelRepository hotelRepository;

	public Hotel addHotel(Hotel hotel) 
	{
		// TODO Auto-generated method stub
		return hotelRepository.save(hotel);
	}
	
	public List<Hotel> getAll() 
	{
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}
	
    public List<Hotel> getByState(String state) throws InvalidAnyException 
    {
    	// TODO Auto-generated method stub
    	List<Hotel> hotels = hotelRepository.findByState(state);
		if (hotels.isEmpty())
			throw new InvalidAnyException("Hotel state Not Found!");
		return hotels;
    }

    public List<Hotel> getByRating(double rating) throws InvalidAnyException 
    {
    	// TODO Auto-generated method stub
    	List<Hotel> hotels = hotelRepository.findByStarRating(rating);
		if (hotels.isEmpty())
			throw new InvalidAnyException("Hotel rating Not Found!");
		return hotels;
    }
    
	public List<Hotel> getByHotelName(String name) throws InvalidAnyException 
	{

		List<Hotel> hotels = hotelRepository.findByName(name);
		if (hotels.isEmpty())
			throw new InvalidAnyException("Hotel Name Not Found!");
		return hotels;
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

	// To Get Approved Hotels
	public List<Hotel> getHotelByApproval() {

		return hotelRepository.findByStatus(HotelStatus.APPROVED);
	}

	// To Get Deletion Requested Hotel
	public List<Hotel> getDeletionRequests() {

		return hotelRepository.findByDeletionRequested(DeletionRequest.Yes);
	}

	public List<Hotel> getAllHotelsUnderUs() 
	{
		return hotelRepository.findAll();
	}

	public Page<Hotel> getall(Pageable pageable)
	{
		// TODO Auto-generated method stub
		return hotelRepository.findAll(pageable);
	}
	
	public Hotel uploadImage(MultipartFile file, int hid) throws IOException, InvalidIDException 
	{
		// TODO Auto-generated method stub
		Hotel hotel = hotelRepository.findById(hid)
 				.orElseThrow(()->new InvalidIDException("Invalid PID given.."));
 		
 		List<String> allowedExtensions = Arrays.asList("png","jpg","jpeg","gif","svg"); 
 		String originalFileName = file.getOriginalFilename(); 
 		System.out.println(originalFileName);
 		String extension= originalFileName.split("\\.")[1];
 		
 		if( !(allowedExtensions.contains(extension))) 
 		{
 			throw new RuntimeException("Image Type Invalid");
 		}
 		
 		
 		String uploadPath= "C:\\Users\\k.jansu\\Documents\\hexaware\\java fsd\\project\\api\\cozyheaven\\uploads";
 		
 		Files.createDirectories(Paths.get(uploadPath));
 		Path path = Paths.get(uploadPath + "\\" +originalFileName); 
 		Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
 		hotel.setImageUrls(path.toString());
 		return hotelRepository.save(hotel);
	}

}
