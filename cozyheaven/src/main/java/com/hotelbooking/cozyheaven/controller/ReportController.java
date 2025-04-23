package com.hotelbooking.cozyheaven.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.model.Booking;
import com.hotelbooking.cozyheaven.model.Payment;
import com.hotelbooking.cozyheaven.service.BookingService;
import com.hotelbooking.cozyheaven.service.PaymentService;
import com.hotelbooking.cozyheaven.service.ReportService;


@RestController
@RequestMapping("/api/report")
public class ReportController
{

	@Autowired
	private BookingService bookingService;
	@Autowired
	private ReportService reportService;
	@Autowired
	private PaymentService paymentService;
	
	// 1 - list of bookings
	@GetMapping("/listofbookings")
	public List<Booking> getAllBooking()
	{
		return bookingService.getAllBooking();
	}
	
	//2 - Count of Bookings
	@GetMapping("/countofbookings")
	public long getCountOfBooking()
	{
		return bookingService.getCountOfBooking();
	}
	
	//3 - Find by date 
	@GetMapping("/getbooking/{bookdate}")
	public List<Booking> getListOfBookingByDate(@PathVariable LocalDateTime bookdate)
	{
		return bookingService.getListOfBookingByDate(bookdate);
	}
	
	//4 - Find By date Count
	@GetMapping("/getbookingcount/{bookdate}")
	public long getListOfBookingByDateCount(@PathVariable LocalDateTime bookdate)
	{
		return bookingService.getListOfBookingByDateCount(bookdate);
	}
	
	//5 - List of payments 
	@GetMapping("/getlistofpayment")
	public List<Payment> getListOfPayment()
	{
		return paymentService.getListOfPayment();
	}
	
	//6 - Total amount in the listofpayment(WHole Amount)
	@GetMapping("/getamountlist")
	public Double getAmountWithListOfPayment()
	{
		return paymentService.getAmountWithListOfPayment();
	}
	
	//7 - list of payments by date
	@GetMapping("/getlistofpayments/{paymentdate}")
	public List<Payment> getListOfPaymentByDate(@PathVariable LocalDateTime paymentdate)
	{
		return paymentService.getListOfPaymentByDate(paymentdate);
	}
	
	//8 - list of payments by date TotalAMountRevenue(Custom AMount)
	@GetMapping("/getamount/{paymentdate}")
	public Double getAmountByCustomDate(@PathVariable LocalDateTime paymentdate)
	{
		return paymentService.getAmountByCustomDate(paymentdate);
	}
	
	
	
}