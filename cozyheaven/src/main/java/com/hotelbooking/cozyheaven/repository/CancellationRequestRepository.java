package com.hotelbooking.cozyheaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.cozyheaven.model.CancellationRequest;


public interface CancellationRequestRepository extends JpaRepository<CancellationRequest, Integer> {

}
