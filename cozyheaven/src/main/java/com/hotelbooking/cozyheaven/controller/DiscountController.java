package com.hotelbooking.cozyheaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.service.DiscountService;

@RestController
@RequestMapping("/api/discount")
public class DiscountController {
	@Autowired
	private DiscountService discountService;

}
