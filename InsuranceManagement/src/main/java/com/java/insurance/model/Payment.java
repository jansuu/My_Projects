package com.java.insurance.model;

import java.sql.Date;

public class Payment {
	private int paymentid;
	private Date paymentdate;
	private int paymentamount;
	private int clientid;
	public int getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}
	public Date getPaymentdate() {
		return paymentdate;
	}
	public void setPaymentdate(Date paymentdate) {
		this.paymentdate = paymentdate;
	}
	public int getPaymentamount() {
		return paymentamount;
	}
	public void setPaymentamount(int paymentamount) {
		this.paymentamount = paymentamount;
	}
	public int getClientid() {
		return clientid;
	}
	public void setClientid(int clientid) {
		this.clientid = clientid;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(int paymentid, Date paymentdate, int paymentamount, int clientid) {
		super();
		this.paymentid = paymentid;
		this.paymentdate = paymentdate;
		this.paymentamount = paymentamount;
		this.clientid = clientid;
	}
	@Override
	public String toString() {
		return "Payment [paymentid=" + paymentid + ", paymentdate=" + paymentdate + ", paymentamount=" + paymentamount
				+ ", clientid=" + clientid + "]";
	}
	

}
