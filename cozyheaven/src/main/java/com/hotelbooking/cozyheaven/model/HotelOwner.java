package com.hotelbooking.cozyheaven.model;

import java.time.LocalDateTime;
import java.util.Objects;

import com.hotelbooking.cozyheaven.enums.GovernmentIDType;
import com.hotelbooking.cozyheaven.enums.IsVerified;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

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
	
	@OneToOne
	private User user;

    

	public HotelOwner(int id, String name, String email, String contact, String address,
			GovernmentIDType governmenttIDType, String governmentIDNumber, String buisnessRegistrationNumber,
			String gstin, String bankDetails, IsVerified isVerified, LocalDateTime createdAt, User user) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.address = address;
		this.governmenttIDType = governmenttIDType;
		this.governmentIDNumber = governmentIDNumber;
		this.buisnessRegistrationNumber = buisnessRegistrationNumber;
		this.gstin = gstin;
		this.bankDetails = bankDetails;
		this.isVerified = isVerified;
		this.createdAt = createdAt;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
	
	@Override
	public int hashCode() {
		return Objects.hash(address, bankDetails, buisnessRegistrationNumber, contact, createdAt, email,
				governmentIDNumber, governmenttIDType, gstin, id, isVerified, name, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HotelOwner other = (HotelOwner) obj;
		return Objects.equals(address, other.address) && Objects.equals(bankDetails, other.bankDetails)
				&& Objects.equals(buisnessRegistrationNumber, other.buisnessRegistrationNumber)
				&& Objects.equals(contact, other.contact) && Objects.equals(createdAt, other.createdAt)
				&& Objects.equals(email, other.email) && Objects.equals(governmentIDNumber, other.governmentIDNumber)
				&& governmenttIDType == other.governmenttIDType && Objects.equals(gstin, other.gstin) && id == other.id
				&& isVerified == other.isVerified && Objects.equals(name, other.name)
				&& Objects.equals(user, other.user);
	}

}
