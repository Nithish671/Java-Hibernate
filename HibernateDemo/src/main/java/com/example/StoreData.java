package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StoreData {
	
	public static void main(String[] args) {
		
		SessionFactory fact = null;
		Session session = null;
		
		try {
			
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
			
			fact = meta.getSessionFactoryBuilder().build();
			session = fact.openSession();
			Transaction t = session.beginTransaction();
			
			Employee e1 = new Employee();
			e1.setName("Denji");
			e1.setSalary(50000);
			
			session.save(e1);
			t.commit();
			System.out.println("Successfully Saved!");
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			fact.close();
			session.close();
			
		}
	}
}
