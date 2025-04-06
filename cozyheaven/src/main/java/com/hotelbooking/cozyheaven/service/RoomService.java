package com.hotelbooking.cozyheaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.repository.RoomRepository;

@Service
public class RoomService 
{
	@Autowired
	private RoomRepository rr;

}
