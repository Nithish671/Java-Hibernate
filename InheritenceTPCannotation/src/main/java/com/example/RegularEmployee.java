package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "regemp")
@AttributeOverrides({
	@AttributeOverride(name = "id", column = @Column(name = "id")),
	@AttributeOverride(name = "name", column = @Column(name = "name"))
})
public class RegularEmployee extends Employee {
	@Column(name = "salary")
	private float salary;
	
	@Column(name = "bonus")
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
