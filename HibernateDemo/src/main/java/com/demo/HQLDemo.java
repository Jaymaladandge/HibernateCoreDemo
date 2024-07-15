package com.demo;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Question;
import com.entity.User;

public class HQLDemo {

	//used javax.persistence.Query; 
	
	public static void main(String[] args) {

		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		
		Query query = session.createQuery("from User");
		List<User> list = query.getResultList();
		list.forEach(u -> {
			System.out.print(u.getUserName() + "'s posts : ");
			u.getPosts().forEach(p -> System.out.print(" " + p.getPost()));
			System.out.println();
		});
		System.out.println("----------------------------------");

		
		
		Query query2 = session.createQuery("from Question q where q.quesId=:id and q.question=:question");
		query2.setParameter("id", Integer.parseInt("3"));
		query2.setParameter("question", "what is oops");

		List<Question> list2 = query2.getResultList();
		list2.forEach(
				q -> System.out.println(q.getQuesId() + ", " + q.getQuestion() + ", " + q.getAnswer().getAnswer()));
		System.out.println("-----------------------------------");

		
		
		Query query3 = session.createQuery("select q.question, a.ans from Question q join q.answer a");
		List<Object[]> list3 = query3.getResultList();
		list3.forEach(entry -> System.out.println(Arrays.toString(entry)));
		
		
		Query query4 = session.createQuery("delete from Question where quesId=:id");
		query4.setParameter("id", Integer.parseInt("4"));
		int n = query4.executeUpdate();
		System.out.println(n+" records deleted" );
		System.out.println("-------------------------------");
		
		
		
		Query query5 = session.createQuery("update Question set question=:ques where quesId=:id");
		query5.setParameter("ques", "What is OOPs");
		query5.setParameter("id", Integer.parseInt("3"));
		n = query5.executeUpdate();
		System.out.println(n+" records updated" );
		
		
		
		
		session.flush();
		tx.commit();
		session.close();
		factory.close();
	}
}

//when select entire Question entity return type will be List<Question>.
//when select specific fields from the any entity return type will be List<Object[]>.