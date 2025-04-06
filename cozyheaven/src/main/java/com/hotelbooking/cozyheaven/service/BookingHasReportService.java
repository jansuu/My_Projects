package com.hotelbooking.cozyheaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.repository.BookingHasReportRepository;

@Service
public class BookingHasReportService {
    @Autowired
    private BookingHasReportRepository bookingHasReportRepository;

}
