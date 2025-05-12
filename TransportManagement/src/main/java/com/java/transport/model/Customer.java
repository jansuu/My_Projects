package com.java.transport.model;

public class Customer {
	
	private int customerId;
	private String customername;
	private int age;
	private String mobile;
	private String email;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public int getAge() {
		return age; 
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int customerId, String customername, int age, String mobile, String email) {
		super();
		this.customerId = customerId;
		this.customername = customername;
		this.age = age;
		this.mobile = mobile;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customername=" + customername + ", age=" + age + ", mobile="
				+ mobile + ", email=" + email + "]";
	}
	
}
