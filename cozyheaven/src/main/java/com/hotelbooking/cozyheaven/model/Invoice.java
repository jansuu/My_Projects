package com.hotelbooking.cozyheaven.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "invoice")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private LocalDateTime invoice_date;

	@Column(nullable = false, length = 512)
	private String billing_details;
	
	@ManyToOne
	private Booking booking;
	
	
	// Sample for checking purpose

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getInvoice_date() {
		return invoice_date;
	}

	public void setInvoice_date(LocalDateTime invoice_date) {
		this.invoice_date = invoice_date;
	}

	public String getBilling_details() {
		return billing_details;
	}

	public void setBilling_details(String billing_details) {
		this.billing_details = billing_details;
	}



}