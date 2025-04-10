package com.hotelbooking.cozyheaven.model;

import java.time.LocalDateTime;

import com.hotelbooking.cozyheaven.enums.GovernmentIDType;
import com.hotelbooking.cozyheaven.enums.IsVerified;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HotelOwner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String contact;

	@Column(nullable = false)
	private String address;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private GovernmentIDType governmenttIDType;

	@Column(nullable = false)
	private String governmentIDNumber;

	@Column(nullable = false)
	private String buisnessRegistrationNumber;

	@Column(nullable = false)
	private String gstin;

	@Column(nullable = false)
	private String bankDetails;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private IsVerified isVerified;

	@Column(nullable = false)
	private LocalDateTime createdAt;



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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}



	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGovernmentIDNumber() {
		return governmentIDNumber;
	}

	public void setGovernmentIDNumber(String governmentIDNumber) {
		this.governmentIDNumber = governmentIDNumber;
	}

	public String getBuisnessRegistrationNumber() {
		return buisnessRegistrationNumber;
	}

	public void setBuisnessRegistrationNumber(String buisnessRegistrationNumber) {
		this.buisnessRegistrationNumber = buisnessRegistrationNumber;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public String getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(String bankDetails) {
		this.bankDetails = bankDetails;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public GovernmentIDType getGovernmenttIDType() {
		return governmenttIDType;
	}

	public void setGovernmenttIDType(GovernmentIDType governmenttIDType) {
		this.governmenttIDType = governmenttIDType;
	}

	public IsVerified getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(IsVerified isVerified) {
		this.isVerified = isVerified;
	}

}
