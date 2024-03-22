package com.example;

import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Map;
import java.util.Set;
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
			
			fact = meta.getSessionFactoryBuilder().build();
			session = fact.openSession();
			
			TypedQuery que = session.createQuery("from Question");
			List<Question> list = que.getResultList();
			
			Iterator<Question> itr = list.iterator();
			
			while(itr.hasNext()) {
				
				Question q = itr.next();
				
				System.out.println("\n" + q.getUsername() + " : " + q.getQuestion() + "\n"
						+ "Answers : ");
				
				Map<String, String> ans = q.getAnswers();
				Set<Map.Entry<String, String>> set = ans.entrySet();
				
				Iterator<Map.Entry<String, String>> ansItr = set.iterator();
				
				while(ansItr.hasNext()) {
					
					Map.Entry<String, String> entry = (Map.Entry<String, String>)ansItr.next();
					
					System.out.println(entry.getKey() + " : " + entry.getValue());
					
				}
				
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			session.close();
			fact.close();
			
		}
		
	}
	
}
