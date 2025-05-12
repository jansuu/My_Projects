package com.hotelbooking.cozyheaven.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.hotelbooking.cozyheaven.model.Hotel;
import com.hotelbooking.cozyheaven.model.Services;
import com.hotelbooking.cozyheaven.repository.ServicesRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ServiceServiceTest 
{
	@InjectMocks
	private ServicesService servicesService;
	
	@Mock
	private ServicesRepository servicesRepository;
	
	 private Services s1;
	 private Services s2;

	 @BeforeEach
	 public void init() 
	 {
	     s1 = new Services(1, "Room Cleaning", "Daily room cleaning service included.");
	     s2 = new Services(2, "Airport Pickup", "Free airport pickup on request.");
	 }
	 
	 @Test
	 public void addService() 
	 {
		when(servicesRepository.save(s2)).thenReturn(s1);
		assertEquals(s1, servicesService.addService(s2));
	 }
	 
		@Test
		public void getAll() 
		{
			List<Services> services = Arrays.asList(s1,s2);
			when(servicesRepository.findAll()).thenReturn(services);
			assertEquals(services, servicesService.getAll());
		}

}
