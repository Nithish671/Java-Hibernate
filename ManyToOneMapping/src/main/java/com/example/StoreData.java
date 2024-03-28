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
		Transaction t= null;
		
		try {
			
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
			
			fact = meta.buildSessionFactory();
			
			session = fact.openSession();
			
			t = session.beginTransaction();
			
			Employee e1 = new Employee();
			e1.setName("Sosuke Aizen");
			e1.setEmail("aizen@bleach.com");
			
			Employee e2 = new Employee();
			e2.setName("Ichigo Kurosaki");
			e2.setEmail("ichigo@bleach.com");
			
			Address a1 = new Address();
			a1.setAddressLine1("Seireitei");
			a1.setCity("Soul Society");
			a1.setPincode(627808);
			a1.setUniverse("Bleach");
			
			e1.setAddress(a1);
			e2.setAddress(a1);
			
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
