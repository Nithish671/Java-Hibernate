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
			
			Employee e = new Employee();
			e.setName("Ichigo Kurosaki");
			
			Address a = new Address();
			a.setCountry("Japan");
			a.setUniverse("Bleach");
			a.setPincode(627808);
			
			e.setAddress(a);
			
			Employee e1 = new Employee();
			e1.setName("Sosuke Aizen");
			e1.setAddress(a);
			
			session.persist(e);
			session.persist(e1);
			
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
