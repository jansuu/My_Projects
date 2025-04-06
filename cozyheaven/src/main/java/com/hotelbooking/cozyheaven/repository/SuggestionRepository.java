package com.hotelbooking.cozyheaven.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelbooking.cozyheaven.model.Suggestion;

public interface SuggestionRepository extends JpaRepository<Suggestion, Integer>{

}
