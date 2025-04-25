package com.hotelbooking.cozyheaven.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.config.JwtUtil;
import com.hotelbooking.cozyheaven.dto.TokenDto;
import com.hotelbooking.cozyheaven.exception.InvalidUsernameException;
import com.hotelbooking.cozyheaven.model.User;
import com.hotelbooking.cozyheaven.service.MyUserService;
import com.hotelbooking.cozyheaven.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController 
{
	@Autowired
 	private AuthenticationManager authenticationManager;
	
	@Autowired
    private MyUserService myUserService;
	
	@Autowired
 	private UserService userService;
	
	@Autowired
 	private JwtUtil jwtUtil;
 	
 	@PostMapping("/signup")
 	public User signUp(@RequestBody User user) throws InvalidUsernameException 
 	{
 		return userService.signUp(user);
 	}
 	
 	
 	@PostMapping("/login")
 	public UserDetails login(Principal principal)
 	{
 		String username = principal.getName();
 		return myUserService.loadUserByUsername(username);
 	}

 	@PostMapping("/token/generate")
 	public TokenDto generateToken(@RequestBody User user,TokenDto dto) {
 		/*Step 1. Build authentication ref based on username,passord given*/
 		Authentication auth = 
 		new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
 	
 		authenticationManager.authenticate(auth);
 		
 		/*Step 2: Generate the token since we know that credentials are correct */
 		String token =  jwtUtil.generateToken(user.getUsername()); 
 		dto.setToken(token);
 		dto.setUsername(user.getUsername());
 		dto.setExpiry(jwtUtil.extractExpiration(token).toString());
 		return dto; 
 	}
 	
 	@GetMapping("/details")
 	public UserDetails getUserDetails(Principal principal) 
 	{
 		String username = principal.getName();
 		return myUserService.loadUserByUsername(username);
 	}
 	


}
