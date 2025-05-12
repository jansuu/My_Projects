package com.hotelbooking.cozyheaven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Season;
import com.hotelbooking.cozyheaven.service.SeasonService;

@RestController
@RequestMapping("/api/season")
public class SeasonController {
	@Autowired
	private SeasonService seasonService;
	
	@PostMapping("/add")
	public Season addSeason(@RequestBody Season season)
	{
		return seasonService.addSeason(season);
	}
	
	@GetMapping("/getall")
	public List<Season> getAllSeason()
	{
		return seasonService.getAllSeason();
	}
	
	@GetMapping("/getbyid/{id}")
	public Season getSeasonById(@PathVariable int id) throws InvalidIDException
	{
		return seasonService.getSeasonById(id);
	}
	

}
