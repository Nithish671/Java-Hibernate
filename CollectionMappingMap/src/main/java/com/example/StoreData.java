package com.example;

import java.util.HashMap;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
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
			
			HashMap<String, String> a1 = new HashMap<String, String>();
			a1.put("Goku", "Dragon Ball is an Anime!");
			a1.put("Ichigo", "Dragon Ball is an Comic!");
			
			HashMap<String, String> a2 = new HashMap<String, String>();
			a2.put("Aizen", "Bleach is an Comic!");
			a2.put("Zoro", "Bleach is an Anime!");
			a2.put("Luffy", "Bleach is an Stain Remover!");
			
			Question q1 = new Question("What is Dragon Ball?","Vegeta", a1);
			Question q2 = new Question("What is Bleach?", "Kisuke Urahara", a2);
			
			session.persist(q1);
			session.persist(q2);
			
			t.commit();
			
			System.out.println("Data Insertion was Successful!");
		} catch(Exception e) {
			
			e.printStackTrace();
			t.rollback();
			
		} finally {
			
			session.close();
			fact.close();
			
		}
		
	}
	
}
