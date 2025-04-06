package com.hotelbooking.cozyheaven.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Discount
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String coupon;
	private String description;
	private int percentage;
	private LocalDate validFromm;
	private LocalDate validTo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCoupon() {
		return coupon;
	}
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPercentage() {
		return percentage;
	}
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	public LocalDate getValidFromm() {
		return validFromm;
	}
	public void setValidFromm(LocalDate validFromm) {
		this.validFromm = validFromm;
	}
	public LocalDate getValidTo() {
		return validTo;
	}
	public void setValidTo(LocalDate validTo) {
		this.validTo = validTo;
	}
	
}
