package com.hotelbooking.cozyheaven.service;

import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Booking;
import com.hotelbooking.cozyheaven.model.Invoice;
import com.hotelbooking.cozyheaven.repository.InvoiceRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class InvoiceServiceTest {

    @InjectMocks
    private InvoiceService invoiceService;

    @Mock
    private InvoiceRepository invoiceRepository;

    Invoice invoice;
    Booking booking;

    @BeforeEach
    void setup() {
        booking = new Booking();
        booking.setId(1);

        invoice = new Invoice();
        invoice.setId(1);
        invoice.setBooking(booking);
        invoice.setInvoice_date(LocalDateTime.now());
        invoice.setBilling_details("Details...");
    }

    @Test
    void testAddInvoice() {
        when(invoiceRepository.save(invoice)).thenReturn(invoice);
        Invoice saved = invoiceService.addInvoice(invoice);
        assertEquals(1, saved.getId());
    }

    @Test
    void testGetInvoiceById_Valid() throws InvalidIDException {
        when(invoiceRepository.findById(1)).thenReturn(Optional.of(invoice));
        Invoice found = invoiceService.getInvoiceById(1);
        assertEquals("Details...", found.getBilling_details());
    }

    @Test
    void testGetInvoiceById_Invalid() {
        when(invoiceRepository.findById(2)).thenReturn(Optional.empty());
        assertThrows(InvalidIDException.class, () -> invoiceService.getInvoiceById(2));
    }

    @Test
    void testGetInvoiceByBookingId_Valid() throws InvalidIDException {
        when(invoiceRepository.findByBooking_Id(1)).thenReturn(Optional.of(invoice));
        Invoice found = invoiceService.getInvoiceByBookingId(1);
        assertEquals(invoice, found);
    }

    @Test
    void testGetAllInvoices() {
        when(invoiceRepository.findAll()).thenReturn(List.of(invoice));
        assertEquals(1, invoiceService.getAllInvoices().size());
    }
}
