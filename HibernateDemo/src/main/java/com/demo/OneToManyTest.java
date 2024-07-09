package com.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Post;
import com.entity.User;

public class OneToManyTest {

	public static void main(String[] args) {

		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = config.buildSessionFactory();

		
		User user = new User();
		user.setUserName("ajay");
		
		Post post = new Post();
		post.setPost("song");
		post.setUser(user);

		Post post2 = new Post();
		post2.setPost("movie");
		post2.setUser(user);

		Post post3 = new Post();
		post3.setPost("pictures");
		post3.setUser(user);

		List<Post> posts = new ArrayList<Post>();
		posts.add(post);
		posts.add(post2);
		posts.add(post3);

		user.setPosts(posts);

		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(user);
		session.save(post);
		session.save(post2);
		session.save(post3);
		
		
		session.flush();
		tx.commit();
		
		
		System.out.println("----------------------Fetch data--------------------------");
		
		User user2 = session.get(User.class, 1);
		System.out.println(user2.getUserName());
		
		List<Post> list = user2.getPosts();
		list.forEach(p->System.out.println(p.getPost()));
		
		
		session.close();
		sessionFactory.close();
	}

}
