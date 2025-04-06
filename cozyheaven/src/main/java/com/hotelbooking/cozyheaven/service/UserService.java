package com.hotelbooking.cozyheaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.repository.UserRepository;

@Service
public class UserService 
{
	@Autowired
	private UserRepository ur;

}
