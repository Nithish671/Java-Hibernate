package com.example;

import java.util.List;
import java.util.Iterator;
import java.util.Set;

import jakarta.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class FetchData {
	
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
			
			TypedQuery que = session.createQuery("from Question");
			List<Question> list = que.getResultList();
			
			Iterator<Question> itr = list.iterator();
			
			while(itr.hasNext()) {
				
				Question q = itr.next();
				System.out.println("\nQuestion : " + q.getQname());
				
				Set<String> s = q.getAnswers();
				Iterator<String> it = s.iterator();
				
				while(it.hasNext()) {
					
					System.out.println(it.next());
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			session.close();
			fact.close();
			
		}
		
	}
	
}
