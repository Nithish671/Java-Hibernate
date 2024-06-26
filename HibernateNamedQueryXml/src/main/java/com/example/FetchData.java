package com.example;

import java.util.List;
import java.util.Iterator;

import jakarta.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class FetchData {
	
	public static void main(String[] args) {
		
		SessionFactory fact = null;
		Session session = null;
		
		try {
			
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
			
			fact = meta.getSessionFactoryBuilder().build();
			session = fact.openSession();
			
			TypedQuery que = session.getNamedQuery("findEmpByName");
			que.setParameter("universe", "Bleach");
			
			List<Employee> list = que.getResultList();
			
			Iterator<Employee> itr = list.iterator();
			
			while(itr.hasNext()) {
				
				Employee e = itr.next();
				
				System.out.println(e);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			session.close();
			fact.close();
			
		}
		
	}
}
