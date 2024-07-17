package com.demo;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Address;
import com.entity.Certificate;
import com.entity.Student;

/**
 * Hello world!
 *
 */
public class App {
	
	
	
	public static void main(String[] args) {

		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		Certificate certificate = new Certificate("Java", "3 months");
		
		Student student = new Student(105, "kiran", "pune",certificate);
		Address address = new Address("mumbai", "maharashtra", true, 9, new Date(), null);
		
		
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		//session.save(student);
		//session.save(address);
		
		session.getTransaction().commit();
		
		
		
		
		System.out.println("--------------------------session.get()-------------------------------");
		
		session = sessionFactory.openSession();
		
		Student student2 = session.get(Student.class, 101); 	//query fired for this object	
		Student student3 = session.get(Student.class, 101); 	//this object will get from cache
		
		Student student4 = session.get(Student.class, 115);		//returns null if no entity present in DB
		System.out.println("Student : "+student4);
		
		
		System.out.println("------------------------session.load()------------------------");
		
		Student student5 = session.load(Student.class, 101);	
		System.out.println("Student : "+student5);				//when we invoked method on instance, object load from cache
																//otherwise from DB. Lazy loading.
		Student student6 = session.load(Student.class, 102);	
		System.out.println("Student : "+student6);				//when we use object, hibernate hits the DB 
		
		
		//Student student7 = session.load(Student.class, 200);
		//System.out.println(student7);							//throws ObjectNotFoundException while entity is not present in DB
		
		session.close();
		sessionFactory.close();
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
  
  
  sesion.flush(); 
  Hibernate needs an active transaction for operations that modify the state of the session, including flush.
  session.flush() forces the session to synchronize its state with the database.
  
  
   
  get() VS load()
  
  get() : get object from cache if not in cache hit the DB. returns null if no entity present in DB.
  load() : get object from cache if not in cache hit the DB. throws ObjectNotFoundException if entity is not present in DB.
  		   lazy loading - return proxy and when we use object then it hit DB. 
 
  
  
  
  
 */