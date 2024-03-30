package com.example;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class EmployeeDao {

	private HibernateTemplate ht;
	
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}
	
	public void saveEmployee(Employee e) {
		ht.save(e);
	}
	
	public void updateEmployee(Employee e) {
		ht.saveOrUpdate(e);
	}
	
	public void deleteEmployee(Employee e) {
		ht.delete((Object)e);
	}
	
	public Employee getById(int id) {
		Employee e = (Employee)ht.get(Employee.class, id);
		return e;
	}
	
	public void getEmployees() {
		
		List<Employee> list = new ArrayList<Employee>();
		list = ht.loadAll(Employee.class);
		
		Iterator<Employee> itr = list.iterator();
		
		System.out.println("Employee List and Details : ");
		
		while(itr.hasNext()) {
			
			Employee e = itr.next();
			
			System.out.println("\n" + e.getId() + " . Name : " + e.getName() + "\n"
					+ "Country : " + e.getCountry() + "\nPincode : " + e.getPincode() + "\n"
							+ "Universe : " + e.getUniverse());
			
		}
		
	}
	
}
