package com.hotelbooking.cozyheaven.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Services 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    private String title;

	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Services(int id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}

	public Services(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	} 
	

}
