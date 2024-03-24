package com.example;

import java.util.ArrayList;

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
			
			Answer ans1 = new Answer("Dragon Ball is an Comic!", "Goku");
			Answer ans2 = new Answer("Dragon Ball is an Anime!", "Krillin");
			
			Answer ans3 = new Answer("Jujutsu Kaisen is an Anime!", "Satoru Gojo");
			Answer ans4 = new Answer("Jujutsu Kaisen is an Comic!", "Yuta Okkotsu");
			
			ArrayList<Answer> list1 = new ArrayList<Answer>();
			list1.add(ans1);
			list1.add(ans2);
			
			ArrayList<Answer> list2 = new ArrayList<Answer>();
			list2.add(ans3);
			list2.add(ans4);
			
			Question que1 = new Question("What is Dragon Ball?", list1);
			Question que2 = new Question("What is Jujutsu Kaisen?", list2);
			
			session.persist(que1);
			session.persist(que2);
			
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
