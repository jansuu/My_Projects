package com.hotelbooking.cozyheaven.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer 
{
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    @Column(nullable = false)
	    private String name;
	    
	    @Column(nullable = false)
	    private String email;
	    
	    @Column(nullable = false)
	    private String address;
	    
	    @Column(nullable = false)
	    private long contact;
	    
	    @Column(nullable = false)
	    private LocalDateTime accountCreatedAt;

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

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public long getContact() {
			return contact;
		}

		public void setContact(long contact) {
			this.contact = contact;
		}

		public LocalDateTime getAccountCreatedAt() {
			return accountCreatedAt;
		}

		public void setAccountCreatedAt(LocalDateTime accountCreatedAt) {
			this.accountCreatedAt = accountCreatedAt;
		}
	    

}
