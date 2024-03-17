package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "conemp321")
@PrimaryKeyJoinColumn(name = "id")
public class ContractEmployee extends Employee {
	
	@Column(name = "payPerHour")
	private float payPerHour;
	
	@Column(name = "contractDuration")
	private String contractDuration;
	
	public void setPayPerHour(float payPerHour) {
		this.payPerHour = payPerHour;
	}
	
	public float getPayPerHour() {
		return payPerHour;
	}
	
	public void setContractDuration(String contractDuration) {
		this.contractDuration = contractDuration;
	}
	
	public String getContractDuration() {
		return contractDuration;
	}
}
