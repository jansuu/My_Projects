package com.java.transport.model;

import java.sql.Time;
import java.sql.Timestamp;
public class Journey {
	
	private int journeyId;
	private int vehicleId;
	private int registrationno;
	private String startstation;
	private String endstation;
	private Timestamp starttime;
	private Timestamp depaturetime;
	private String type;
	private int adminId;
	private int price;
	public int getJourneyId() {
		return journeyId;
	}
	public void setJourneyId(int journeyId) {
		this.journeyId = journeyId;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public int getRegistrationno() {
		return registrationno;
	}
	public void setRegistrationno(int registrationno) {
		this.registrationno = registrationno;
	}
	public String getStartstation() {
		return startstation;
	}
	public void setStartstation(String startstation) {
		this.startstation = startstation;
	}
	public String getEndstation() {
		return endstation;
	}
	public void setEndstation(String endstation) {
		this.endstation = endstation;
	}
	public Timestamp getStarttime() {
		return starttime;
	}
	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}
	public Timestamp getDepaturetime() {
		return depaturetime;
	}
	public void setDepaturetime(Timestamp depaturetime) {
		this.depaturetime = depaturetime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Journey() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Journey(int journeyId, int vehicleId, int registrationno, String startstation, String endstation,
			Timestamp starttime, Timestamp depaturetime, String type, int adminId, int price) {
		super();
		this.journeyId = journeyId;
		this.vehicleId = vehicleId;
		this.registrationno = registrationno;
		this.startstation = startstation;
		this.endstation = endstation;
		this.starttime = starttime;
		this.depaturetime = depaturetime;
		this.type = type;
		this.adminId = adminId;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Journey [journeyId=" + journeyId + ", vehicleId=" + vehicleId + ", registrationno=" + registrationno
				+ ", startstation=" + startstation + ", endstation=" + endstation + ", starttime=" + starttime
				+ ", depaturetime=" + depaturetime + ", type=" + type + ", adminId=" + adminId + ", price=" + price
				+ "]";
	}
	
}
