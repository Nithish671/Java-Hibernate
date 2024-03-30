package com.example;

public class Employee {

	int id;
	String name;
	String country;
	String universe;
	int pincode;
	
	public void setId(int id) {
		this.id= id;
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
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCountry() {
		return country;
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
	
	public String toString() {
		return "\n" + id + " . Name : " + name + "\nCountry : " + country + "\n"
				+ "Universe : " + universe + "\nPincode : " + pincode;
	}
}
