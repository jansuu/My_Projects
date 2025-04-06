package com.hotelbooking.cozyheaven.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Room 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(nullable = false)
    private String name;
	
	@Column(nullable = false)
	private double pricePerNight;
	
	@Column(nullable = false)
	private int maxCapacity;
	
	@Column(nullable = false)
    private String aminities;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private RoomAvailabilityStatus availabilityStatus;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private RoomType type;
	
	 @ManyToOne
	 private Hotel hotel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public String getAminities() {
		return aminities;
	}

	public void setAminities(String aminities) {
		this.aminities = aminities;
	}

	public RoomAvailabilityStatus getAvailabilityStatus() {
		return availabilityStatus;
	}

	public void setAvailabilityStatus(RoomAvailabilityStatus availabilityStatus) {
		this.availabilityStatus = availabilityStatus;
	}

	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	 

}
