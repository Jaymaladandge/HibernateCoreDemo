package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Answer;
import com.entity.Question;

public class MappingTest {

	public static void main(String[] args) {

		Answer answer = new Answer();
		answer.setAnswer("Swing used for GUI");

		Question question = new Question();
		question.setQuestion("what is Swing ?");
		question.setAnswer(answer);
 
		
		/*
		 * Question question2 =new Question();
		 * question2.setQuestion("what is collection");
		 * 
		 * Answer answer2 =new Answer(); answer2.setAnswer("Collection is framework");
		 * answer2.setQuestion(question2);
		 */
		
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();

		Transaction tx = session.beginTransaction();

		//session.save(answer);  			//need to save answer explicitly while we not use cascading on parent Question
		session.save(question);
		
		/*
		 * session.save(question2); session.save(answer2);
		 */
		
		
		
		tx.commit();
		
		System.out.println("\n------------------------Fetch data---------------------------");
		
		Question question2 = session.load(Question.class, 1);
		System.out.println(question2.getQuestion());
		System.out.println(question2.getAnswer().getAnswer());
		
		
		
		session.close();
		sessionFactory.close();
	}
}
