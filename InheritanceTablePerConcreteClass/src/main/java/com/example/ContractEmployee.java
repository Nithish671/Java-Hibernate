package com.example;

public class ContractEmployee extends Employee {
	private float payPerHour;
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
