package com.hotelbooking.cozyheaven.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private float rating;
	private String comment;
	@Column(nullable = false)
	private LocalDate reviewDate;
	
	private String responseText;
	private LocalDate responseDate;

	@ManyToOne
	private Booking booking;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDate getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(LocalDate reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getResponseText() {
		return responseText;
	}

	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

	public LocalDate getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(LocalDate responseDate) {
		this.responseDate = responseDate;
	}
	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Review(int id, float rating, String comment, LocalDate reviewDate, String responseText,
			LocalDate responseDate, Booking booking) {
		super();
		this.id = id;
		this.rating = rating;
		this.comment = comment;
		this.reviewDate = reviewDate;
		this.responseText = responseText;
		this.responseDate = responseDate;
		this.booking = booking;
	}
}
