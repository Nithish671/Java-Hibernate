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
		Transaction t = null;
		
		try {
			
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
			
			fact = meta.getSessionFactoryBuilder().build();
			session = fact.openSession();
			
			t = session.beginTransaction();
			
			Employee e1 = new Employee();
			e1.setName("Rukia Kuchiki");
			e1.setEmail("byakuya@bleach.com");
			
			Employee e2 = new Employee();
			e2.setName("Renji Abarai");
			e2.setEmail("renji@bleach.com");
			
			Address a1 = new Address();
			a1.setAddressLine1("Rukon District");
			a1.setCity("Soul Society");
			a1.setPincode(627808);
			a1.setUniverse("Bleach");
			
			session.persist(e1);
			session.persist(e2);
			
			t.commit();
			
			System.out.println("Data Insertion Successful!");
			
		} catch(Exception e) {
			
			e.printStackTrace();
			t.rollback();
			
		} finally {
			
			session.close();
			fact.close();
			
		}
		
	}
}
