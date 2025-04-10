package com.hotelbooking.cozyheaven.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.cozyheaven.model.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Integer>
{
	List<Discount> findByHotelId(int hid);
	List<Discount> findBySeasonId(int sid);

}
