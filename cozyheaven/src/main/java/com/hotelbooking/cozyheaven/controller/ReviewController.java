package com.hotelbooking.cozyheaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Booking;
import com.hotelbooking.cozyheaven.model.Review;
import com.hotelbooking.cozyheaven.service.BookingService;
import com.hotelbooking.cozyheaven.service.ReviewService;

@RestController
@RequestMapping("/api/review")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private BookingService bookingService;
	
	 // Submit a review
	@PostMapping("/add/{bid}")
	public Review submitReview(@PathVariable int bid, @RequestBody Review review) throws InvalidIDException
	{
		Booking booking =  bookingService.getBookingById(bid);
		
		review.setBooking(booking);
		review = reviewService.submitReview(review);
		return review;
	}

    // Get review by ID
    @GetMapping("/{reviewId}")
    public Review getReviewById(@PathVariable int reviewId) throws InvalidIDException {
        return reviewService.getReviewById(reviewId);
    }

    // Get reviews for a specific hotel
    @GetMapping("/hotel/{hotelId}")
    public Review getReviewsByRoom(@PathVariable int RoomId) throws InvalidIDException {
        return reviewService.getReviewsByHotel(RoomId);
    }

//    // Get reviews by customer
//    @GetMapping("/customer/{customerId}")
//    public Review getReviewsByCustomer(@PathVariable int customerId) throws InvalidIDException {
//        return reviewService.getReviewsByCustomer(customerId);
//    }
}

