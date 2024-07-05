package com.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Address;
import com.entity.Student;

/**
 * Hello world!
 *
 */
public class App {
	
	
	
	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		Student student = new Student(101, "vijay", "mumbai");
		Address address = new Address("mumbai", "maharashtra", true, 9, new Date(), null);
		
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		session.save(student);
		session.save(address);
		
		session.getTransaction().commit();
		
		session.close();
	}
}


/*
 
openSession: 
-When you call SessionFactory.openSession, it always creates a new Session object and give it to you.
-You need to explicitly flush and close these session objects.
-As session objects are not thread safe, you need to create one session object per request in multi-threaded environment and 
one session per request in web applications too.
 
 getCurrentSession: 
 -When you call SessionFactory.getCurrentSession, it will provide you session object which is in hibernate 
  context and managed by hibernate internally. it creates a new Session if it does not exist, otherwise use same session 
  which is in current hibernate context. 
 -It is bound to transaction scope. 
  It automatically flushes and closes session when transaction ends, so you do not need to do it externally.
 -If you are using hibernate in single-threaded environment , you can use getCurrentSession, 
  as it is faster in performance as compared to creating a new session each time. 
 -need to add following property to hibernate.cfg.xml to use getCurrentSession method
  <property name="hibernate.current_session_context_class">thread</property> 
  
  
  
 */