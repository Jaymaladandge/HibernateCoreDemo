package com.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Answer;

public class HQLPagination {

	//used org.hibernate.query.Query
	
	public static void main(String[] args) {
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Query<Answer> query = session.createQuery("from Answer", Answer.class);
		query.setFirstResult(0);
		query.setMaxResults(5);
		
		
		List<Answer> answers = query.getResultList();
		answers.forEach(a->System.out.println(a));
		
		
		session.flush();
		tx.commit();
		session.close();
		factory.close();
		
	}
}
