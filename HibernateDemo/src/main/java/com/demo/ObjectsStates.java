package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Certificate;
import com.entity.Student;

public class ObjectsStates {
	 
	public static void main(String[] args) {
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		
		Student student = new Student();
		student.setCity("mumbai");
		student.setName("Ram");
		student.setCertificate(new Certificate("Hibernate", "1 month"));
		//here student is in Transient state.
		//at this state neither associate with session nor database
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(student);			//call any method to persist save(),persist(),saveOrUpdate(),update()
		//here student is in Persistent state
		//at this state student associate with session and Database
		
		student.setName("Raghav");
		tx.commit();
		session.close();
		
		//here student is in Detached state
		//at this state student associate only with Database not with session
		
		factory.close();
		
		//When call delete() student will be in Removed state
	}

}

/*
Transient State
1)When objects are generated by an application but are not connected to any session.
2)The objects are generated by a closed session.



Persistent State
1)Using the hibernated session, save the entity object into the database table.
2)Using the hibernated session, load the entity object into the database table.
session.persist(e);
session.save(e);
session.saveOrUpdate(e);
session.update(e);
session.merge(e);
session.lock(e);
Load the entity using get() or load() method.
Changes to the object are tracked and synchronized with the database during the session's flush operation.



Detached State
session.detach(e);
session.evict(e);
session.clear();
session.close();

To reconnect the detached object to a new hibernate session
merge()
update()
load()
refresh()
save()
update()


Removed State 
To make a removed entity object we will call session.delete().




*/
