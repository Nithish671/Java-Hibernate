package com.example;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("contractEmployee")
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
