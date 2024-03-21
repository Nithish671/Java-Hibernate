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
			
			fact = meta.buildSessionFactory();
			
			session = fact.openSession();
			t = session.beginTransaction();
			
			ArrayList<String> l1 = new ArrayList<String>();
			l1.add("Bleach is an Anime!");
			l1.add("Bleach is an Comic!");
			
			ArrayList<String> l2 = new ArrayList<String>();
			l2.add("Jujutsu Kaisen is an Anime!");
			l2.add("Jujutsu Kaisen is an Comic!");
			
			Question q1 = new Question();
			q1.setQname("What is Bleach?");
			q1.setAnswers(l1);
			
			Question q2 = new Question();
			q2.setQname("What is Jujutsu Kaisen?");
			q2.setAnswers(l2);
			
			session.persist(q1);
			session.persist(q2);
			
			t.commit();
			
			System.out.println("Data Insertion Sucessful!");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			t.rollback();
			
		} finally {
			
			session.close();
			fact.close();
			
		}
		
	}
	
}
