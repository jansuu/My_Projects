package com.hotelbooking.cozyheaven.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.hotelbooking.cozyheaven.service.MyUserService;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private MyUserService myUserService;

	@Autowired
	private JwtFilter jwtFilter;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception 
	{
		http.csrf(csrf -> csrf.disable())
		        .cors(withDefaults())
				.authorizeHttpRequests((authorize) -> authorize.requestMatchers("api/auth/signup").permitAll()
						.requestMatchers("/api/auth/login").authenticated()
						.requestMatchers("/api/auth/token/generate").permitAll()
						.requestMatchers("/api/auth/user/details").authenticated()
						.requestMatchers("/api/hotelowner/add").permitAll()
						.requestMatchers("/api/hotelowner/get/{ownerid}").hasAnyAuthority("Admin","HotelOwner")
						.requestMatchers("/api/hotelowner/update/{ownerid}").hasAnyAuthority("Admin","HotelOwner")
						.requestMatchers("/api/hotel/add/{ownerid}").hasAuthority("HotelOwner")
						.requestMatchers("/api/room/add/{hid}").hasAuthority("HotelOwner")
						.requestMatchers("/api/room/getall/{hid}").permitAll()
						.requestMatchers("/api/hotel/getall").permitAll()
						.requestMatchers("/api/hotel/getAll").permitAll()
						.requestMatchers("/api/hotel/image/upload/{hid}").permitAll()
						.requestMatchers("/api/hotel/getbyowner/{hotelownerid}").hasAnyAuthority("Admin","HotelOwner")
						.requestMatchers("/api/hotel/getbyhotel/{hotelid}").hasAnyAuthority("Admin","HotelOwner")
						.requestMatchers("/api/hotel/update/{hotelid}/{ownerid}").hasAuthority("HotelOwner")
						.requestMatchers("/api/hotel/deleterequest/{hotelid}/{ownerid}").hasAuthority("HotelOwner")
						.requestMatchers("/api/hotel/approved").hasAuthority("HotelOwner")
						.requestMatchers("/api/hotel/bookingbyhotel/{hotelid}").hasAuthority("HotelOwner")
						.requestMatchers("/api/hotel/bookingbyowner/{ownerid}").hasAuthority("HotelOwner")
						.requestMatchers("/api/hotel/reviewbyhotel/{hotelid}").hasAuthority("HotelOwner")
						.requestMatchers("/api/hotel/reviewbyowner/{ownerid}").hasAuthority("HotelOwner")
						.requestMatchers("/api/hotel/review/response/{reviewid}").hasAuthority("HotelOwner")
						.requestMatchers("/api/hotel/pendingrequest").hasAuthority("HotelOwner")
						.requestMatchers("/api/hotel/deletionrequested").hasAuthority("HotelOwner")
						.requestMatchers("/api/hotel/recent/bookings/{ownerid}").hasAuthority("HotelOwner")
						.requestMatchers("/api/cancellationrequest/add/{bookingID}").hasAuthority("Customer")
						.requestMatchers("/api/cancellationrequest/getall").hasAuthority("HotelOwner")
						.requestMatchers("/api/cancellationrequest/getbyhotel/{hotelid}").hasAuthority("HotelOwner")
						.requestMatchers("/api/cancellationrequest/getbyapproved").hasAuthority("HotelOwner")
						.requestMatchers("/api/cancellationrequest/getbyrejected").hasAuthority("HotelOwner")
						.requestMatchers("/api/cancellationrequest/accept/{cancellationID}").hasAuthority("HotelOwner")
						.requestMatchers("/api/cancellationrequest/reject/{cancellationID}").hasAuthority("HotelOwner")
						.requestMatchers("/api/refund/proceed/{cancellationID}").hasAuthority("HotelOwner")
						.requestMatchers("/api/admin/add/{userid}").permitAll()
						.requestMatchers("/api/verificationrequest/add/{ownerId}").hasAuthority("HotelOwner")
						.requestMatchers("/api/verificationrequest/approveOwner/{verificationid}").hasAuthority("Admin")
						.requestMatchers("/api/verificationrequest/rejectOwner/{verificationid}").hasAuthority("Admin")
						.requestMatchers("/api/verificationrequest/add/{hotelId}").hasAuthority("HotelOwner")
						.requestMatchers("/api/verificationrequest/approveHotel/{verificationid}").hasAuthority("Admin")
						.requestMatchers("/api/verificationrequest/rejectHotel/{verificationid}").hasAuthority("Admin")
						.requestMatchers("/api/verificationrequest/get/{id}").hasAuthority("Admin")
						.requestMatchers("/api/verificationrequest/getbyhotel/{hotelId}").hasAuthority("Admin")
						.requestMatchers("/api/verificationrequest/pending").hasAuthority("Admin")
						.requestMatchers("/api/verificationrequest/getbyowner/{ownerId}").hasAuthority("Admin")
						.requestMatchers("/api/verificationrequest/all").hasAuthority("Admin")
						.requestMatchers("/api/discount/add/{hid}/{sid}").hasAuthority("Admin")//
						.requestMatchers("/api/customer/add").permitAll()
						.requestMatchers("/api/discount/gethotelname/{discountname}").hasAnyAuthority("Admin","Customer")
						.requestMatchers("/api/services/add").permitAll()
						.requestMatchers("/api/services/getall").permitAll()
						.requestMatchers("/api/contact/add").hasAuthority("CUSTOMER")
						.requestMatchers("/api/hotel/getbyname").permitAll()
						.requestMatchers("/api/hotel/getbystate").permitAll()
						.requestMatchers("/api/hotel/getbycity").permitAll()
				        .requestMatchers("/api/hotel/getbyrating").permitAll()
				        .requestMatchers("/api/booking/add/{rid}/{cid}").permitAll()
				        .requestMatchers("/api/payment/add/{bid}").permitAll()
				        .requestMatchers("/api/customer/profile/update").hasAuthority("CUSTOMER")
				        .requestMatchers("/api/booking/customer/{customerId}").permitAll()
				        .requestMatchers("/api/review/add/{bid}").permitAll()
						
						.anyRequest().permitAll()
						)
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

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

	@Bean
	AuthenticationManager getAuthManager(AuthenticationConfiguration auth) throws Exception 
	{

		return auth.getAuthenticationManager();

	}
	
	@Bean
	UrlBasedCorsConfigurationSource corsConfigurationSource() 
	{
	    CorsConfiguration configuration = new CorsConfiguration();
	    configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
	    configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
	    configuration.setAllowedHeaders(Arrays.asList("*"));
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration);
	    return source;
	}

}
