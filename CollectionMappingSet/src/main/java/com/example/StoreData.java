package com.example;

import java.util.HashSet;
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
			
			HashSet<String> hs = new HashSet<String>();
			hs.add("Tokyo Revengers is an Anime!");
			hs.add("Tokyo Revengers is an Comic!");
			
			HashSet<String> hs1 = new HashSet<String>();
			hs1.add("Demon Slayer is an Anime!");
			hs1.add("Demon Slayer is an Comic!");
			
			Question q = new Question();
			q.setQname("What is Tokyo Revengers?");
			q.setAnswers(hs);
			
			Question q1 = new Question();
			q1.setQname("What is Demon Slayer?");
			q1.setAnswers(hs1);
			
			session.persist(q);
			session.persist(q1);
			
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
