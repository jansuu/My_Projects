package com.java.insurance.model;

public class Client {
	private int clientid;
	private String clientname;
	private String contactinfo;
	private String policy;
	public int getClientid() {
		return clientid;
	}
	public void setClientid(int clientid) {
		this.clientid = clientid;
	}
	public String getClientname() {
		return clientname;
	}
	public void setClientname(String clientname) {
		this.clientname = clientname;
	}
	public String getContactinfo() {
		return contactinfo;
	}
	public void setContactinfo(String contactinfo) {
		this.contactinfo = contactinfo;
	}
	public String getPolicy() {
		return policy;
	}
	public void setPolicy(String policy) {
		this.policy = policy;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(int clientid, String clientname, String contactinfo, String policy) {
		super();
		this.clientid = clientid;
		this.clientname = clientname;
		this.contactinfo = contactinfo;
		this.policy = policy;
	}
	@Override
	public String toString() {
		return "Client [clientid=" + clientid + ", clientname=" + clientname + ", contactinfo=" + contactinfo
				+ ", policy=" + policy + "]";
	}
	

}
