package com.hotelbooking.cozyheaven.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Review;
import com.hotelbooking.cozyheaven.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;

	public Review getReviewById(int reviewId) throws InvalidIDException 
	{
		// TODO Auto-generated method stub
		Optional<Review> optional = reviewRepository.findById(reviewId);
		if(optional.isEmpty())
		{
			throw new InvalidIDException("review ID is invalid...");
		}
		return optional.get();
	}

	public Review getReviewsByHotel(int roomId) throws InvalidIDException 
	{
		// TODO Auto-generated method stub
		Optional<Review> optional = reviewRepository.findByBookingRoomId(roomId);
		if(optional.isEmpty())
		{
			throw new InvalidIDException("review ID is invalid...");
		}
		return optional.get();
	}

//	public Review getReviewsByCustomer(int customerId) throws InvalidIDException 
//	{
//		// TODO Auto-generated method stub
//		Optional<Review> optional = reviewRepository.findByCustomerId(customerId);
//		if(optional.isEmpty())
//		{
//			throw new InvalidIDException("review ID is invalid...");
//		}
//		return optional.get();
//	}

	public Review submitReview(Review review) {
		// TODO Auto-generated method stub
		return reviewRepository.save(review);
	}

}
