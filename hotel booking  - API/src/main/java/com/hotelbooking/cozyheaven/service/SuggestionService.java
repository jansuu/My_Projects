package com.hotelbooking.cozyheaven.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.cozyheaven.repository.SuggestionRepository;

@Service
public class SuggestionService {
	
	@Autowired
	private SuggestionRepository suggestionRepository;

}
