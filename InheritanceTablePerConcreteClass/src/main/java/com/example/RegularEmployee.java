package com.example;

public class RegularEmployee extends Employee {
	private float salary;
	private int bonus;
	
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	public float getSalary() {
		return salary;
	}
	
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	public int getBonus() {
		return bonus;
	}
}
