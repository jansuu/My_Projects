package com.hotelbooking.cozyheaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.cozyheaven.model.VerificationRequest;

public interface VerificationRequestRepository extends JpaRepository<VerificationRequest, Integer> {

}
