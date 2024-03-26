package com.example;

import java.util.List;

public class Answer {
	
	private int id;
	private String answer;
	private String user;
	private List<Question> questions;
	
	public Answer() {}
	
	public Answer(String answer, String user) {
		
		this.answer = answer;
		this.user = user;
		
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	public List<Question> getQuestions() {
		return questions;
	}
	
}
