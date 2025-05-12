package com.hotelbooking.cozyheaven.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.model.Services;
import com.hotelbooking.cozyheaven.repository.ServicesRepository;

@Service
public class ServicesService 
{
	@Autowired
	private ServicesRepository servicesRepository;

	public Services addService(Services services) 
	{
		// TODO Auto-generated method stub
		return servicesRepository.save(services);
	}

	public List<Services> getAll() 
	{
		// TODO Auto-generated method stub
		return servicesRepository.findAll();
	}

	

}
