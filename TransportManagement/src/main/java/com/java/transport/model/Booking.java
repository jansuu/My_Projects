package com.java.transport.model;

import java.sql.Date;

public class Booking {
	
	private int bookingId;
	private int customerId;
	private int journeyId;
	private Date bookingdate;
	private Date startdate;
	private Date enddate;
	private int noofdays;
	private int advanceamount;
	public int getBookingId() {
		return bookingId;
	} 
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getJourneyId() {
		return journeyId;
	}
	public void setJourneyId(int journeyId) {
		this.journeyId = journeyId;
	}
	public Date getBookingdate() {
		return bookingdate;
	}
	public void setBookingdate(Date bookingdate) {
		this.bookingdate = bookingdate;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public int getNoofdays() {
		return noofdays;
	}
	public void setNoofdays(int noofdays) {
		this.noofdays = noofdays;
	}
	public int getAdvanceamount() {
		return advanceamount;
	}
	public void setAdvanceamount(int advanceamount) {
		this.advanceamount = advanceamount;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(int bookingId, int customerId, int journeyId, Date bookingdate, Date startdate, Date enddate,
			int noofdays, int advanceamount) {
		super();
		this.bookingId = bookingId;
		this.customerId = customerId;
		this.journeyId = journeyId;
		this.bookingdate = bookingdate;
		this.startdate = startdate;
		this.enddate = enddate;
		this.noofdays = noofdays;
		this.advanceamount = advanceamount;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", customerId=" + customerId + ", journeyId=" + journeyId
				+ ", bookingdate=" + bookingdate + ", startdate=" + startdate + ", enddate=" + enddate + ", noofdays="
				+ noofdays + ", advanceamount=" + advanceamount + "]";
	}
	

}
