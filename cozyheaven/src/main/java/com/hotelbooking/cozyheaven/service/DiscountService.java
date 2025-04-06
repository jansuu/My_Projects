package com.hotelbooking.cozyheaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.repository.DiscountRepository;

@Service
public class DiscountService {
	@Autowired
	private DiscountRepository discountRepository;

}
