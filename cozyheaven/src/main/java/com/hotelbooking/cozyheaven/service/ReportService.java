package com.hotelbooking.cozyheaven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.model.Booking;
import com.hotelbooking.cozyheaven.repository.BookingRepository;
import com.hotelbooking.cozyheaven.repository.ReportRepository;

@Service
public class ReportService {
	@Autowired
	private ReportRepository reportRepository;
	@Autowired
	private BookingRepository bookingRepository;

	public List<Booking> getAllBooking() 
	{
		return bookingRepository.findAll();
	}

}
