package com.hotelbooking.cozyheaven.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.model.Services;
import com.hotelbooking.cozyheaven.service.ServicesService;

@RestController
@RequestMapping("/api/services")
public class ServicesController 
{
	@Autowired
	private ServicesService servicesService;
	
	Logger logger =  LoggerFactory.getLogger("ServicesController"); 
	
	// add services
	@PostMapping("/add")
	public Services addService(@RequestBody Services services ) 
	{
		logger.info("Adding new service: {}", services);
		return servicesService.addService(services);
	}
	
	// get all services
	@GetMapping("/getall")
	public List<Services> getAll()
	{
		logger.info("Fetching all services");
		return servicesService.getAll();
	}

}
