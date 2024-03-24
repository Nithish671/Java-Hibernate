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
			
			TypedQuery que = session.createQuery("from Question");
			
			List<Question> list = que.getResultList();
			
			Iterator<Question> itr = list.iterator();
			
			while(itr.hasNext()) {
				
				Question q = itr.next();
				
				System.out.println("\n\nQuestion " + q.getId() + " : " + q.getQuestion() + "\n"
						+ "Answers : \n");
				
				List<Answer> ans = q.getAnswers();
				
				Iterator<Answer> it = ans.iterator();
				
				int i = 1;
				
				while(it.hasNext()) {
					
					Answer a = it.next();
					
					System.out.println(i + " . " + a.getAnswer() + "\n"
							+ "Posted By, " + a.getUser());
					
					i++;
					
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
