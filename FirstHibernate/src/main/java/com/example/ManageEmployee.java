package com.example;

import java.util.List;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageEmployee {
	private static SessionFactory fact;
	
	public static void main(String[] args) {
		try {
		fact = new Configuration().configure().buildSessionFactory();
		} catch(Throwable ex) {
			System.out.println("Failed to create SessionFatory object " + ex);
			throw new ExceptionInInitializerError(ex);
		}
		
		ManageEmployee emp = new ManageEmployee();
		
		emp.addEmployee("Gojo", 50000);
		emp.addEmployee("Yuji", 50000);
		emp.addEmployee("Eren", 50000);
		
		emp.updateEmployee(20, 100000);
		
		emp.listEmployees();
	}
	
	public void addEmployee(String name, float salary) {
		Session session = fact.openSession();
		Transaction tx = null;
		Integer employeeId = null;
		
		try {
			tx = session.beginTransaction();
			Employee emp = new Employee(name, salary);
			employeeId = (Integer)session.save(emp);
			tx.commit();
			
			System.out.println("\nInserted Employee : " + "\n"
					+ "Id : " + employeeId
					+ "\nName : " + name);
		} catch(HibernateException e) {
			if(tx != null) {tx.rollback();}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	public void listEmployees() {
		Session session = fact.openSession(); 
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
		    List emp = session.createQuery("FROM Employee").list();
		    
		    System.out.println("\nEmployee List : ");
		    for(Iterator it = emp.iterator(); it.hasNext();) {
		    	Employee e = (Employee)it.next(); 
			    System.out.println("Id : " + e.getId() +"\nName : " + e.getName() + "\n"
					               + "Salary : " + e.getSalary() + "\n");
			    }
		    tx.commit();
		    } catch(HibernateException e) {
		    	if(tx != null) {tx.rollback();}
		    	e.printStackTrace();
		    	} finally {
		    		session.close();
		    	}
	}
	
	public void updateEmployee(Integer EmployeeId, float salary) {
		Session session = fact.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Employee emp = (Employee)session.get(Employee.class, EmployeeId);
			emp.setSalary(salary);
			
			session.update(emp);
			tx.commit();
			System.out.println("\nUpdated Employee : " + emp.getName());
		} catch(HibernateException e) {
			if(tx != null) {tx.rollback();}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void deleteEmployee(Integer EmployeeId) {
		Session session = fact.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			Employee e = (Employee)session.get(Employee.class, EmployeeId);
			session.delete(e);
			tx.commit();
			System.out.println("\nDeleted Employee : \nId : " + EmployeeId + "\n"
					+ "Name : " + e.getName());
		} catch(HibernateException e) {
			if(tx != null) {tx.rollback();}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
