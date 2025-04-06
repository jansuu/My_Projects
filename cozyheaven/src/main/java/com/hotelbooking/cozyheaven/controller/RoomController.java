package com.hotelbooking.cozyheaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.service.RoomService;

@RestController
@RequestMapping("/api/room")
public class RoomController 
{
	@Autowired
	private RoomService rs;

}
