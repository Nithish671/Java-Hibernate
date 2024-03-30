package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InsertTest {
	
	public static void main(String[] args) {
		
		ApplicationContext con = new ClassPathXmlApplicationContext("beans.xml");
		
		EmployeeDao ed = (EmployeeDao)con.getBean("ed");
		
		Employee e1 = (Employee)ed.getById(2);
		
		System.out.println(e1);
		
	}

}
