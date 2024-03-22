package com.example;

import java.util.Set;

public class Question {
	private int id;
	private String qname;
	private Set<String> answers;
	
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
	
	public void setAnswers(Set<String> answers) {
		this.answers = answers;
	}
	
	public Set<String> getAnswers() {
		return answers;
	}
}
