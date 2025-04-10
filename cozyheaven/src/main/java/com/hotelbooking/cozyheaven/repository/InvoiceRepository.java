package com.hotelbooking.cozyheaven.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.cozyheaven.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

	 Optional<Invoice> findByBooking_Id(int bookingId);


}