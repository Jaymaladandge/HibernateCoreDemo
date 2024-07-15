package com.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;
import com.entity.Project;

public class ManyToManyTest {
 
	public static void main(String[] args) {

		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();

		Employee e1 = new Employee();
		e1.setEmpName("ajay");

		Employee e2 = new Employee();
		e2.setEmpName("vijay");

		Project p1 = new Project();
		p1.setProjectName("Finance project");

		Project p2 = new Project();
		p2.setProjectName("Ticket booking");

		List<Employee> emps = new ArrayList<Employee>();
		emps.add(e1);
		emps.add(e2);

		List<Project> projects = new ArrayList<Project>();
		projects.add(p1);
		projects.add(p2);
		
		e1.setProjects(projects);
		p1.setEmps(emps);
		
		

		Session session = factory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);
		
		session.flush();
		tx.commit();

		session.close();
		factory.close();
	}
}
