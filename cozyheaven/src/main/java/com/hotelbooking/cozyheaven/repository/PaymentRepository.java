package com.hotelbooking.cozyheaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.cozyheaven.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>  {

}
