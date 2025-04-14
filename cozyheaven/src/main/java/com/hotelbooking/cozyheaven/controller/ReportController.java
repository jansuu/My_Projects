	package com.hotelbooking.cozyheaven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Report;
import com.hotelbooking.cozyheaven.service.ReportService;

@RestController
@RequestMapping("/api/report")
public class ReportController {

	@Autowired
	private ReportService reportService;
	
	/*LIST OF HOTELS*/
	// --by location
	// --by season
	
	/*Fetch the Bookings of Date of Booking basis,*/
	
	 //  Add new report
    @PostMapping("/add")
    public Report addReport(@RequestBody Report report) {
        return reportService.addReport(report);
    }

    //  Get all reports
    @GetMapping("/all")
    public List<Report> getAllReports() {
        return reportService.getAllReports();
    }

    //  Get report by report ID
    @GetMapping("/{id}")
    public Report getReportById(@PathVariable int id) throws InvalidIDException {
        return reportService.getReportById(id);
    }

    //  Get report by booking ID
    @GetMapping("/booking/{bookingId}")
    public Report getReportByBookingId(@PathVariable int bookingId) throws InvalidIDException {
        return reportService.getReportByBookingId(bookingId);
    }

    //  Get reports by month and year
    @GetMapping("/filter/month-year")
    public List<Report> getByMonthAndYear(@RequestParam int month, @RequestParam int year) {
        return reportService.getReportsByMonthYear(month, year);
    }

    //  Get reports by room type
    @GetMapping("/filter/room-type/{type}")
    public List<Report> getByRoomType(@PathVariable String type) {
        return reportService.getReportsByRoomType(type);
    }

    //  Get reports by season like summer and winter
    @GetMapping("/filter/season/{seasonName}")
    public List<Report> getBySeason(@PathVariable String seasonName) {
        return reportService.getReportsBySeason(seasonName);
    }

    // Get occupancy-related reports
    @GetMapping("/occupancy")
    public List<Report> getOccupancyReports() {
        return reportService.getOccupancyReports();
    }

    //  Get reports filtered by place keyword (from report name)
    @GetMapping("/filter/place/{location}")
    public List<Report> getByPlace(@PathVariable String location) {
        return reportService.getReportsByPlace(location);
    }
}