package com.hotelbooking.cozyheaven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Invoice;
import com.hotelbooking.cozyheaven.service.InvoiceService;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {
	@Autowired
	private InvoiceService invoiceService;
	
	
	// Add Invoice
    @PostMapping("/add")
    public Invoice addInvoice(@RequestBody Invoice invoice) {
        return invoiceService.addInvoice(invoice);
    }

    // Get All Invoices
    @GetMapping("/all")
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    // Get Invoice by ID
    @GetMapping("/get/{id}")
    public Invoice getInvoiceById(@PathVariable int id) throws InvalidIDException {
        return invoiceService.getInvoiceById(id);
    }

    // Get Invoice by Booking ID
    @GetMapping("/get/by-booking/{bookingId}")
    public Invoice getInvoiceByBookingId(@PathVariable int bookingId) throws InvalidIDException {
        return invoiceService.getInvoiceByBookingId(bookingId);
    }
}








