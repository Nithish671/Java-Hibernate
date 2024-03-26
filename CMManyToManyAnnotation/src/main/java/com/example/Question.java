package com.example;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "que")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String question;
	
	@ManyToMany(targetEntity = Answer.class, cascade = {CascadeType.ALL})
	@JoinTable(name = "ques_ans",
	joinColumns = {@JoinColumn(name = "q_id")},
	inverseJoinColumns = {@JoinColumn(name = "ans_id")})
	private List<Answer> answers;
	
	public Question() {}
	
	public Question(String question, List<Answer> answers) {
		
		this.question = question;
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
	
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	public List<Answer> getAnswers() {
		return answers;
	}
	
}
