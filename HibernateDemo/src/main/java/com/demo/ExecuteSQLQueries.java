package com.demo;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.entity.Answer;

public class ExecuteSQLQueries {

	public static void main(String[] args) {

		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		String sql = "select * from answer";

		NativeQuery<Object[]> nativeQuery = session.createSQLQuery(sql);
		List<Object[]> answers = nativeQuery.getResultList();
		answers.forEach(a -> System.out.println(Arrays.toString(a)));

		session.flush();
		tx.commit();
		session.close();
		factory.close();
	}
}
