package com.hotelbooking.cozyheaven.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Suggestion
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String content;
	@Enumerated(EnumType.STRING)
	private SuggestionStatus suggestionStatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public SuggestionStatus getSuggestionStatus() {
		return suggestionStatus;
	}
	public void setSuggestionStatus(SuggestionStatus suggestionStatus) {
		this.suggestionStatus = suggestionStatus;
	}
	

}
