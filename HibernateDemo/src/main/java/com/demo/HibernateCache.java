package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Student;


public class HibernateCache {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session1 = factory.openSession();
		
		Student student1 = session1.get(Student.class,101);
		
		session1.close();
		
		
		
		
		Session session2 = factory.openSession();
		
		Student student3 = session2.get(Student.class, 101);
		
		session2.close();
		
		factory.close();
		
	}
}


/*
 
 First-Level Cache :
 Scope: Session-level, specific to a single session.
 Automatic and mandatory; cannot be disabled. 
  
  
  
 Second-Level Cache:
 Scope: SessionFactory-level, shared across sessions.
 Exists as long as the SessionFactory is alive.
 Optional and configurable.
  
  
 
  */






