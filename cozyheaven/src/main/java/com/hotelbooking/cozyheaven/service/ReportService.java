package com.hotelbooking.cozyheaven.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Report;
import com.hotelbooking.cozyheaven.repository.ReportRepository;

@Service
public class ReportService {
	@Autowired
	private ReportRepository reportRepository;


	 // Add report
    public Report addReport(Report report) {
        return reportRepository.save(report);
    }

    // Get all reports
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    // Get report by report ID
    public Report getReportById(int id) throws InvalidIDException {
        Optional<Report> optional = reportRepository.findById(id);
        if (optional.isEmpty())
            throw new InvalidIDException("Report ID not found!");
        return optional.get();
    }

    // Get report by booking ID
    public Report getReportByBookingId(int bookingId) throws InvalidIDException {
        return reportRepository.findByBookingId(bookingId)
                .orElseThrow(() -> new InvalidIDException("Report not found for booking ID: " + bookingId));
    }

    // Get report by month & year
    public List<Report> getReportsByMonthYear(int month, int year) {
        return reportRepository.findByMonthAndYear(month, year);
    }

    // Get hotel occupancy reports
    public List<Report> getOccupancyReports() {
        return reportRepository.findAll(); 
    }

    // Get reports filtered by room type
    public List<Report> getReportsByRoomType(String string) {
        return reportRepository.findByRoomType(string);
    }

    // Get reports filtered by season
    public List<Report> getReportsBySeason(String seasonName) {
        return reportRepository.findByReportNameContainingIgnoreCase(seasonName);
    }
    
    // Get report by place 
    public List<Report> getReportsByPlace(String location) {
        return reportRepository.findAll()
                .stream()
                .filter(r -> r.getReportName().toLowerCase().contains(location.toLowerCase()))
                .collect(Collectors.toList());
    }
}


