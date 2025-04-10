package com.hotelbooking.cozyheaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.cozyheaven.model.BookingHasReport;
import com.hotelbooking.cozyheaven.model.Customer;

public interface BookingHasReportRepository extends JpaRepository<BookingHasReport, Integer> {
	
	

}
