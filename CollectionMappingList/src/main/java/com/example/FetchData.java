package com.example;

import java.util.List;
import java.util.Iterator;

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
			
			TypedQuery query = session.createQuery("from Question");
			List<Question> list = query.getResultList();
			
			Iterator<Question> itr = list.iterator();
			
			while(itr.hasNext()) {
				
				Question q = itr.next();
				System.out.println("Question Name : " + q.getQname());
				
                List<String> list2 = q.getAnswers();
				
				Iterator<String> itr2 = list2.iterator();
				
				while(itr2.hasNext()) {
					
					System.out.println(itr2.next());
					
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
