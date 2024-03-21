package com.example;

import java.util.List;

public class Question {
	private int id;
	private String qname;
	private List<String> answers;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setQname(String qname) {
		this.qname = qname;
	}
	
	public String getQname() {
		return qname;
	}
	
	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
	
	public List<String> getAnswers() {
		return answers;
	}
}
