package com.hotelbooking.cozyheaven.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Invoice;
import com.hotelbooking.cozyheaven.repository.InvoiceRepository;

@Service
public class InvoiceService {
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	
	public Invoice addInvoice(Invoice invoice) {
	    return invoiceRepository.save(invoice);
	}


    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(int id) throws InvalidIDException {
        Optional<Invoice> optional = invoiceRepository.findById(id);
        if (optional.isEmpty()) {
            throw new InvalidIDException("Invoice ID Not Found!");
        }
        return optional.get();
    }

  

    public Invoice getInvoiceByBookingId(int bookingId) throws InvalidIDException {
        Optional<Invoice> optional = invoiceRepository.findByBooking_Id(bookingId);
        if (optional.isEmpty()) {
            throw new InvalidIDException("No invoice found for the given booking ID!");
        }
        return optional.get();
    }

}
