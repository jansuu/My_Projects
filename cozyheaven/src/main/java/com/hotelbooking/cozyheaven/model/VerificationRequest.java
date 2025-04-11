package com.hotelbooking.cozyheaven.model;

import com.hotelbooking.cozyheaven.enums.ApprovalStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "verification_request")
public class VerificationRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private int id;

	@Column(nullable = false, length = 255)
	private String licensen_number;

	@Column(nullable = false)
	private String property_ownership_proof;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private ApprovalStatus approval_status;
	
	
	// Admin Relationship Removed

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLicensen_number() {
		return licensen_number;
	}

	public void setLicensen_number(String licensen_number) {
		this.licensen_number = licensen_number;
	}

	public String getProperty_ownership_proof() {
		return property_ownership_proof;
	}

	public void setProperty_ownership_proof(String property_ownership_proof) {
		this.property_ownership_proof = property_ownership_proof;
	}

	public ApprovalStatus getApproval_status() {
		return approval_status;
	}

	public void setApproval_status(ApprovalStatus approval_status) {
		this.approval_status = approval_status;
	}


}