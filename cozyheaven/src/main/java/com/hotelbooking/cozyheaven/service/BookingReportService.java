package com.hotelbooking.cozyheaven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.model.BookingReport;
import com.hotelbooking.cozyheaven.repository.BookingReportRepository;

@Service
public class BookingReportService {
    @Autowired
    private BookingReportRepository bookingReportRepository;

	public List<BookingReport> getAllBooking() {
		return bookingReportRepository.findAll();
	}
    
    

}
