package com.hotelbooking.cozyheaven.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.cozyheaven.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>  {

	Optional<Payment> findByBookingId(int bookingId);

//	Optional<Payment> findByCustomer_Id(int customerId);


	

}
