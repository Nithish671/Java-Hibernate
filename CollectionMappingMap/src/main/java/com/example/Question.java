package com.example;

import java.util.Map;

public class Question {
	
	private int id;
	private String question, username;
	private Map<String, String> answers;
	
	public Question() {}
	
	public Question(String question,String username, Map<String, String> answers) {
		super();
		
		this.question = question;
		this.username = username;
		this.answers = answers;
		
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username; 
	}
	
	public void setAnswers(Map<String, String> answers) {
		this.answers = answers;
	}
	
	public Map<String, String> getAnswers() {
		return answers;
	}
	
}
