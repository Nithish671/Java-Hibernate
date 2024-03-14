package com.example;

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
			
			Employee e1 = new Employee();
			e1.setName("Vegeta");
			
			RegularEmployee e2 = new RegularEmployee();
			e2.setName("Yuji");
			e2.setSalary(50000);
			e2.setBonus(10000);
			
			ContractEmployee e3 = new ContractEmployee();
			e3.setName("Sanji");
			e3.setContractDuration("8 Hours");
			e3.setPayPerHour(25000);
			
			session.persist(e1);
			session.persist(e2);
			session.persist(e3);
			
			t.commit();
			
			System.out.println("Data Insertion Sucessful!");
			
		} catch(Exception e) {
			
			e.printStackTrace();
			t.rollback();
			
		} finally {
			
			session.close();
			fact.close();
			
		}
		
	}
}
