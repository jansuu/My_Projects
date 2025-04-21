package com.hotelbooking.cozyheaven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.model.Discount;
import com.hotelbooking.cozyheaven.model.Hotel;
import com.hotelbooking.cozyheaven.repository.DiscountRepository;

@Service
public class DiscountService {
	@Autowired
	private DiscountRepository discountRepository;

	public Discount addDiscount(Discount discount) 
	{
			return discountRepository.save(discount);
	}

	public List<Discount> getDisountByHotelId(int hid) 
	{
		return discountRepository.findByHotelId(hid);
	}

	public List<Discount> getDisountBySeasonId(int sid) 
	{
		return discountRepository.findBySeasonId(sid);
	}

	public List<Discount> getAllDiscount() 
	{
		return discountRepository.findAll();
	}

}
