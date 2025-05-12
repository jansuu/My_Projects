package com.hotelbooking.cozyheaven.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hotelbooking.cozyheaven.model.Discount;
import com.hotelbooking.cozyheaven.model.Hotel;

public interface DiscountRepository extends JpaRepository<Discount, Integer>
{
	List<Discount> findByHotelId(int hid);
	List<Discount> findBySeasonId(int sid);
	@Query("SELECT d.hotel FROM Discount d WHERE d.coupon = :discountname")//This is Java Persistence Query Language(JPQL) to fetch Hotels
	List<Hotel> findHotelByCoupon(String discountname);

}
