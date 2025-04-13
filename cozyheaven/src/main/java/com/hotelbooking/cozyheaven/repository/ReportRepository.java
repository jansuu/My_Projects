package com.hotelbooking.cozyheaven.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.cozyheaven.model.Booking;
import com.hotelbooking.cozyheaven.model.Report;

public interface ReportRepository extends JpaRepository<Report, Integer>
{

//	List<Booking> getAllBooking();
}
