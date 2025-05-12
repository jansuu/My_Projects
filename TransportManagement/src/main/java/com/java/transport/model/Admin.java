package com.java.transport.model;

import java.sql.Date;
public class Admin {
	
	private int adminid;
	private String name;
	private Date dob;
	private Date doj;
	private String mobile;
	private String username;
	private String password;
	private String email;
	private Gender gender;
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	} 
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int adminid, String name, Date dob, Date doj, String mobile, String username, String password,
			String email, Gender gender) {
		super();
		this.adminid = adminid;
		this.name = name;
		this.dob = dob;
		this.doj = doj;
		this.mobile = mobile;
		this.username = username;
		this.password = password;
		this.email = email;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", name=" + name + ", dob=" + dob + ", doj=" + doj + ", mobile=" + mobile
				+ ", username=" + username + ", password=" + password + ", email=" + email + ", gender=" + gender + "]";
	}
	
	
	
	
}
