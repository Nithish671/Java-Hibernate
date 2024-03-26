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
			
			Answer ans1 = new Answer("Bleach is an Anime!", "Renji");
			Answer ans2 = new Answer("Bleach is an Comic!", "Chad");
			Answer ans3 = new Answer("Bleach is an Stain Remover!", "Sosuke Aizen");
			
			Answer ans4 = new Answer("Tokyo Revengers is an Anime!", "Sana Manjiro");
			Answer ans5 = new Answer("Tokyo Revengers is an Comic!", "Keisuke Baji");
			
			ArrayList<Answer> a1 = new ArrayList<Answer>();
			a1.add(ans1);
			a1.add(ans2);
			a1.add(ans3);
			
			ArrayList<Answer> a2 = new ArrayList<Answer>();
			a2.add(ans4);
			a2.add(ans5);
			
			Question q1 = new Question("What is Bleach?", a1);
			Question q2 = new Question("What is Tokyo Revengers?", a2);
			
			session.persist(q1);
			session.persist(q2);
			
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
