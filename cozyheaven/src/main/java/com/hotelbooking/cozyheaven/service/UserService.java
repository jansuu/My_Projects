package com.hotelbooking.cozyheaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.exception.InvalidUsernameException;
import com.hotelbooking.cozyheaven.model.User;
import com.hotelbooking.cozyheaven.repository.UserRepository;

@Service
public class UserService 
{
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	public User signUp(User user) throws InvalidUsernameException 
	{
		// TODO Auto-generated method stub
		User user1 = ur.findByUsername(user.getUsername());
		if(user1 != null)
		{
			throw new InvalidUsernameException(" account already existing");
		}
		
		if(user.getRole() == null)
		{
			user.setRole("USER_DEFAULT");
		}
			
		String encodedPass = bcrypt.encode(user.getPassword());
		
		//attach encoded password to user 
		user.setPassword(encodedPass);
		
		return ur.save(user);
	}

}
