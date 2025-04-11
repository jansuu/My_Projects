package com.hotelbooking.cozyheaven.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.cozyheaven.enums.ApprovalStatus;
import com.hotelbooking.cozyheaven.model.Hotel;
import com.hotelbooking.cozyheaven.model.HotelOwner;
import com.hotelbooking.cozyheaven.model.VerificationRequest;

public interface VerificationRequestRepository extends JpaRepository<VerificationRequest, Integer> {

	List<VerificationRequest> findByHotelOwnerAndHotel(HotelOwner owner, Hotel hotel);

	List<VerificationRequest> findByStatus(ApprovalStatus status);

}
