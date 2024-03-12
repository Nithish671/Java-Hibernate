package com.example;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("regularEmployee")
public class RegularEmployee extends Employee {
	@Column(name = "salary")
	private float salary;
	
	@Column(name = "bonus")
	private int bonus;
	
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	public float salary() {
		return salary;
	}
	
	public void setBonus(int bonus) {
		this.bonus = bonus;
	} 
	
	public int bonus() {
		return bonus;
	}
}
