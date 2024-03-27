package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "address123")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "addressId")
	private int addressId;
	private String addressLine1, city, universe;
	private int pincode;
	
	@OneToOne(targetEntity = Employee.class)
	private Employee employee;
	
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	
	public int getAddressId() {
		return addressId;
	}
	
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setUniverse(String universe) {
		this.universe = universe;
	}
	
	public String getUniverse() {
		return universe;
	}
	
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	public int getPincode() {
		return pincode;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
}
