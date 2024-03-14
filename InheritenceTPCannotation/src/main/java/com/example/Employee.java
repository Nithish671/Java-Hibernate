package com.example;

import jakarta.persistence.*;

@Entity
@Table(name="emp1")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
