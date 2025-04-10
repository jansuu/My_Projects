package com.hotelbooking.cozyheaven.model;

import java.time.LocalDateTime;

import com.hotelbooking.cozyheaven.enums.DeletionRequest;
import com.hotelbooking.cozyheaven.enums.HotelAvailability;
import com.hotelbooking.cozyheaven.enums.HotelStatus;
import com.hotelbooking.cozyheaven.enums.HotelType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private HotelType type;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String state;

	@Column(nullable = false)
	private String zip;

	@Column(nullable = false)
	private String country;

	@Column(nullable = false)
	private String contactEmail;

	@Column(nullable = false)
	private long contact;

	@Column(nullable = false)
	private String imageUrls;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private HotelStatus status;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private HotelAvailability isAvailable;

	@Column(nullable = false)
	private String commonAmenities;

	@Column(nullable = false)
	private String licenseDetails;

	@Column(nullable = false)
	private String propertyProofDetails;

	@Column(nullable = false)
	private double starRating;

	@Column(nullable = false)
	private LocalDateTime createdAt;

	@Column(nullable = false)
	private LocalDateTime approvedAt;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private DeletionRequest deletionRequested;

	// relationship
	@ManyToOne
	private HotelOwner hotelOwner;

	

	

	public HotelOwner getHotelOwner() {
		return hotelOwner;
	}

	public void setHotelOwner(HotelOwner hotelOwner) {
		this.hotelOwner = hotelOwner;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(String imageUrls) {
		this.imageUrls = imageUrls;
	}

	public String getCommonAmenities() {
		return commonAmenities;
	}

	public void setCommonAmenities(String commonAmenities) {
		this.commonAmenities = commonAmenities;
	}

	public String getLicenseDetails() {
		return licenseDetails;
	}

	public void setLicenseDetails(String licenseDetails) {
		this.licenseDetails = licenseDetails;
	}

	public String getPropertyProofDetails() {
		return propertyProofDetails;
	}

	public void setPropertyProofDetails(String propertyProofDetails) {
		this.propertyProofDetails = propertyProofDetails;
	}

	public double getStarRating() {
		return starRating;
	}

	public void setStarRating(double starRating) {
		this.starRating = starRating;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getApprovedAt() {
		return approvedAt;
	}

	public void setApprovedAt(LocalDateTime approvedAt) {
		this.approvedAt = approvedAt;
	}

	public DeletionRequest getDeletionRequested() {
		return deletionRequested;
	}

	public void setDeletionRequested(DeletionRequest deletionRequested) {
		this.deletionRequested = deletionRequested;
	}

	public HotelType getType() {
		return type;
	}

	public void setType(HotelType type) {
		this.type = type;
	}

	public HotelStatus getStatus() {
		return status;
	}

	public void setStatus(HotelStatus status) {
		this.status = status;
	}

	public HotelAvailability getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(HotelAvailability isAvailable) {
		this.isAvailable = isAvailable;
	}
	

}
