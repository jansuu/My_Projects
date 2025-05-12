package com.java.transport.model;

public class Payment {
	
	private int paymentid;
	private int bookingid;
	private int finalamount;
	public int getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public int getFinalamount() {
		return finalamount;
	}
	public void setFinalamount(int finalamount) {
		this.finalamount = finalamount;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(int paymentid, int bookingid, int finalamount) {
		super();
		this.paymentid = paymentid;
		this.bookingid = bookingid;
		this.finalamount = finalamount;
	}
	@Override
	public String toString() {
		return "Payment [paymentid=" + paymentid + ", bookingid=" + bookingid + ", finalamount=" + finalamount + "]";
	}
	

}
