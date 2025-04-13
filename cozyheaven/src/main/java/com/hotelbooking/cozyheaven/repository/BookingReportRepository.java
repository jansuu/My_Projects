package com.hotelbooking.cozyheaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.cozyheaven.model.BookingReport;


public interface BookingReportRepository extends JpaRepository<BookingReport, Integer> {
	
	

}
