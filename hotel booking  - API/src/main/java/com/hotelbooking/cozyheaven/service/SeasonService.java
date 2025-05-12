package com.hotelbooking.cozyheaven.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.exception.InvalidIDException;
import com.hotelbooking.cozyheaven.model.Season;
import com.hotelbooking.cozyheaven.repository.SeasonRepository;

@Service
public class SeasonService {
	
	@Autowired
	private SeasonRepository seasonRepository;

	public Season addSeason(Season season) 
	{	
		return seasonRepository.save(season);
	}

	public List<Season> getAllSeason() 
	{
		return seasonRepository.findAll();
	}
	
	public Season getSeasonById(int id) throws InvalidIDException {
		// TODO Auto-generated method stub
		Optional<Season> optional = seasonRepository.findById(id);
		if(optional.isEmpty())
		{
			throw new InvalidIDException("Season ID is invalid...");
		}
		return optional.get();
	}

}
