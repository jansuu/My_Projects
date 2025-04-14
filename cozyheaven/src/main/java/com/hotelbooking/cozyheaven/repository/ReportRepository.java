package com.hotelbooking.cozyheaven.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.hotelbooking.cozyheaven.model.Report;

public interface ReportRepository extends JpaRepository<Report, Integer>
{

//	List<Booking> getAllBooking();
	
	  Optional<Report> findByBookingId(int bookingId);

	    List<Report> findByMonthAndYear(int month, int year);

	    List<Report> findByRoomType(String string);

		List<Report> findByReportNameContainingIgnoreCase(String seasonName);

		

}
