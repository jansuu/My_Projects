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

import com.hotelbooking.cozyheaven.enums.DeletionRequest;
import com.hotelbooking.cozyheaven.enums.HotelStatus;
import com.hotelbooking.cozyheaven.enums.Status;
import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Booking;
import com.hotelbooking.cozyheaven.model.Hotel;
import com.hotelbooking.cozyheaven.model.HotelOwner;
import com.hotelbooking.cozyheaven.model.Review;
import com.hotelbooking.cozyheaven.service.BookingService;
import com.hotelbooking.cozyheaven.service.HotelOwnerService;
import com.hotelbooking.cozyheaven.service.HotelService;
import com.hotelbooking.cozyheaven.service.ReviewService;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
	@Autowired
	private HotelService hotelService;
	@Autowired
	private HotelOwnerService hotelOwnerService;
	@Autowired
	private BookingService bookingService;
	@Autowired
	private ReviewService reviewService;

	// Adding Hotel With Owner ID

	@PostMapping("/add/{hotelownerid}")
	public Hotel addHotel(@PathVariable int hotelownerid, @RequestBody Hotel hotel) throws InvalidIDException {

		HotelOwner owner = hotelOwnerService.getOwnerByID(hotelownerid);
		hotel.setHotelOwner(owner);
		return hotelService.addHotel(hotel);

	}

	// Get Hotels With Owner Id

	@GetMapping("/get/{hotelownerid}")
	public List<Hotel> getHotelByOwnerID(@PathVariable int hotelownerid) throws InvalidIDException {
		HotelOwner owner = hotelOwnerService.getOwnerByID(hotelownerid);
		return hotelService.getHotelByOwnerID(hotelownerid);

	}

	// Edit Hotel Details -- need to confirm owning status

	@PutMapping("/update/{hotelid}/{hotelownerid}")
	public Hotel updateHotel(@PathVariable int hotelid, @PathVariable int hotelownerid, @RequestBody Hotel hotel)
			throws InvalidIDException {

		HotelOwner owner = hotelOwnerService.getOwnerByID(hotelownerid);

		Hotel hotelsFind = hotelService.findByHotelID(hotelid);

		System.out.println(hotelsFind.toString());

		hotelsFind.setIsAvailable(hotel.getIsAvailable());
		return hotelService.addHotel(hotelsFind);

	}

	// Delete Request For Hotel
	@DeleteMapping("deleterequest/{hotelid}/{hotelownerid}")
	public Hotel deleteHotel(@PathVariable int hotelid, @PathVariable int hotelownerid,
			@RequestParam DeletionRequest status) throws InvalidIDException {

		HotelOwner owner = hotelOwnerService.getOwnerByID(hotelownerid);

		Hotel hotel = hotelService.findByHotelID(hotelid);

		hotel.setDeletionRequested(status);
		return hotelService.addHotel(hotel);

	}

	// To Get Bookings By Specific Hotel
	@GetMapping("/bookingbyhotel/{hotelid}")
	public List<Booking> getBookingByHotel(@PathVariable int hotelid) {
		List<Booking> booking = bookingService.getBookingByHotelID(hotelid);
		return booking;
	}

	// To Get Bookings By All Hotels Owned By Specific Owner
	@GetMapping("/bookingbyowner/{ownerid}")
	public List<Booking> getBookingByOwner(@PathVariable int ownerid) {

		List<Booking> booking = bookingService.getBookingByOwner(ownerid);
		return booking;

	}

	// To Get Reviews By Specific Hotels
	@GetMapping("review/{hotelid}")
	public List<Review> getReviewByHotel(@PathVariable int hotelid) {
		return reviewService.getReviewByHotel(hotelid);
	}

	// To Reply For Review
	@PutMapping("/review/response/{reviewid}")
	public Review responseReview(@PathVariable int reviewid, @RequestBody Review response) throws InvalidIDException {

		Review review = reviewService.getReviewById(reviewid);

		review.setResponseText(response.getResponseText());
		review.setResponseDate(response.getResponseDate());
		return reviewService.submitReview(review);
	}

	// To Get Pending Requests Of Hotel Verification
	@GetMapping("/pendingRequest")
	public List<Hotel> pendingRequests() {
		return hotelService.getPendingRequests();
	}

}
