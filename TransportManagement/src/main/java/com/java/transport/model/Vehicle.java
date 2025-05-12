package com.java.transport.model;

public class Vehicle {
	
	private int vehicleId;
	private int registrationno;
	private String vehicletype;
	private String vehiclename;
	private int capacity;
	private String status;
	private int quantity;
	private int adminId;
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
	public String getVehicletype() {
		return vehicletype;
	}
	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}
	public String getVehiclename() {
		return vehiclename;
	}
	public void setVehiclename(String vehiclename) {
		this.vehiclename = vehiclename;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vehicle(int vehicleId, int registrationno, String vehicletype, String vehiclename, int capacity,
			String status, int quantity, int adminId) {
		super();
		this.vehicleId = vehicleId;
		this.registrationno = registrationno;
		this.vehicletype = vehicletype;
		this.vehiclename = vehiclename;
		this.capacity = capacity;
		this.status = status;
		this.quantity = quantity;
		this.adminId = adminId;
	}
	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", registrationno=" + registrationno + ", vehicletype=" + vehicletype
				+ ", vehiclename=" + vehiclename + ", capacity=" + capacity + ", status=" + status + ", quantity="
				+ quantity + ", adminId=" + adminId + "]";
	}
	

}
