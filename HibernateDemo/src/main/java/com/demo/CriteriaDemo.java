package com.demo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.entity.Answer;

public class CriteriaDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		Criteria criteria = session.createCriteria(Answer.class);
		List<Answer> list = criteria.list();
		list.stream().filter(ans -> ans.getAnswer().contains("Hibernate")).forEach(System.out::println);
		
		System.out.println("-------------------------------------------");
		
		Criteria criteria2 = session.createCriteria(Answer.class);
		criteria2.add(Restrictions.like("ans", "%Hibernate%"));
		List<Answer> list2 = criteria2.list();
		list2.forEach(System.out::println);
	}
}
