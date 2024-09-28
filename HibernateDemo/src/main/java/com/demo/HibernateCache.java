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
  
  
 
Session 1: The first time you load Student with ID 101, Hibernate will query the database, fetch the entity, and store it in the second-level 
 cache because of the @Cacheable annotation and the specified caching strategy (READ_ONLY).
Session 2: The second time you attempt to load the same Student entity (with ID 101), Hibernate will retrieve the entity from the second-level 
 cache rather than querying the database again. This demonstrates the benefit of caching: reduced database hits and faster access to frequently 
used data.

The READ_ONLY strategy means that the entity will only be read from the cache and will not be modified, making this suitable for 
data that doesn't change frequently. 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
  */






