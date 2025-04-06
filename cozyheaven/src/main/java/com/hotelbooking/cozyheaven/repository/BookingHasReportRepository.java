package com.hotelbooking.cozyheaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.cozyheaven.model.BookingHasReport;

public interface BookingHasReportRepository extends JpaRepository<BookingHasReport, Integer> {

}
