package com.hotelbooking.cozyheaven.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.hotelbooking.cozyheaven.service.MyUserService;


@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
	@Autowired
	private MyUserService myUserService;
	
	@Bean
 	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception 
	{
 		http
 		.csrf(csrf->csrf.disable())
 			.authorizeHttpRequests((authorize) -> authorize
 				.requestMatchers("").permitAll()
 				.requestMatchers("").authenticated()
 				.anyRequest().authenticated()
 			)
 		.authenticationProvider(getAuth())
 		.httpBasic(Customizer.withDefaults());
 		
 		return http.build();
 	}
 	
	@Bean
	AuthenticationProvider getAuth() 
	{
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setPasswordEncoder(passEncoder());
		dao.setUserDetailsService(myUserService);	
		return dao;
	}
 	
 	@Bean
	BCryptPasswordEncoder passEncoder()
 	{
		return new BCryptPasswordEncoder();
	}

}
