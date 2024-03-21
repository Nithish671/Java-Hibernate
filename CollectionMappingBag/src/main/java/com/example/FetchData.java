package com.example;

import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Iterator;

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
			
			fact = meta.buildSessionFactory();
			session = fact.openSession();
			
			TypedQuery query = session.createQuery("from Question");
			
			List<Question> list = query.getResultList();
			
			Iterator<Question> itr = list.iterator();
			
			while(itr.hasNext()) {
				
				Question q = itr.next();
				
				System.out.println("\nQuestion : " + q.getQname());
				
				List<String> l1 = q.getAnswers();
				
				Iterator<String> it1 = l1.iterator();
				
				while(it1.hasNext()) {
					
					System.out.println(it1.next());
					
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
