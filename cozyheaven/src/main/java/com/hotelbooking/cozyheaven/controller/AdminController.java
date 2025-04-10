package com.hotelbooking.cozyheaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	

}
