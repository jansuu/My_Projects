package com.java.insurance.model;

import java.sql.Date;

public class Claim {
	private int claimid;
	private int claimnumber;
	private Date datefiled;
	private int claimamount;
	private Status status;
	private String policy;
	private int clientid;
	public int getClaimid() {
		return claimid;
	}
	public void setClaimid(int claimid) {
		this.claimid = claimid;
	}
	public int getClaimnumber() {
		return claimnumber;
	}
	public void setClaimnumber(int claimnumber) {
		this.claimnumber = claimnumber;
	}
	public Date getDatefiled() {
		return datefiled;
	}
	public void setDatefiled(Date datefiled) {
		this.datefiled = datefiled;
	}
	public int getClaimamount() {
		return claimamount;
	}
	public void setClaimamount(int claimamount) {
		this.claimamount = claimamount;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getPolicy() {
		return policy;
	}
	public void setPolicy(String policy) {
		this.policy = policy;
	}
	public int getClientid() {
		return clientid;
	}
	public void setClientid(int clientid) {
		this.clientid = clientid;
	}
	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Claim(int claimid, int claimnumber, Date datefiled, int claimamount, Status status, String policy,
			int clientid) {
		super();
		this.claimid = claimid;
		this.claimnumber = claimnumber;
		this.datefiled = datefiled;
		this.claimamount = claimamount;
		this.status = status;
		this.policy = policy;
		this.clientid = clientid;
	}
	@Override
	public String toString() {
		return "Claim [claimid=" + claimid + ", claimnumber=" + claimnumber + ", datefiled=" + datefiled
				+ ", claimamount=" + claimamount + ", status=" + status + ", policy=" + policy + ", clientid="
				+ clientid + "]";
	}
	

}
