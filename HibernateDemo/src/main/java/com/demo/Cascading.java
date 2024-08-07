package com.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Answer;
import com.entity.Post;
import com.entity.Question;
import com.entity.User;

public class Cascading {

	public static void main(String[] args) {
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		
		Answer answer = new Answer();
		answer.setAnswer("use to develope server side applications");
		
		Question question = new Question();
		question.setQuestion("What is Spring");
		question.setAnswer(answer);
		
		
		 //session.save(question);							//no need to save answer because we use cascading
		  Question question2 = session.get(Question.class, 3);
		//session.delete(question2);							//we delete question related child entity deleted automatically
		
		
		if(question2 != null) {
			question2.getAnswer().setAnswer("java component");  
			question2.setQuestion("What is swings");
			session.update(question2);
		}else {
			System.out.println("===============No entity in database with given id================");
		}
		
		
		System.out.println("----------------------------------------------------------------------");
		
		
		User user = session.get(User.class, 1);
		List<Post> posts = user.getPosts();
		
		posts.stream().filter(post -> post.getPost().equals("song")).findFirst().ifPresent(p -> posts.remove(p)); //here we remove song post from list of posts hence user not referring to song post entity so now hibernate will delete it from database automatically because we use "orphanRemoval = true" in User class 
		
		
		session.flush();
		tx.commit();
		session.close();
		factory.close();
		
	}
	
	
	
}



/*
 
 
 
 Cascading in Hibernate refers to the automatic persistence of related entities. When a change is made to an entity, 
 such as an update or deletion, the changes can be cascaded to related entities as well.
 Cascading can be configured using annotations, such as @OneToMany(cascade = CascadeType.ALL), or through XML configuration files.
 
CascadeType.ALL
CascadeType.PERSIST
CascadeType.MERGE
CascadeType.REMOVE
CascadeType.REFRESH
CascadeType.DETACH
CascadeType.REPLICATE
CascadeType.SAVE_UPDATE
 

 CascadeType.ALL is a cascading type in Hibernate that specifies that all state transitions (create, update, delete, and refresh) 
 should be cascaded from the parent entity to the child entities.
 
 
 CascadeType.PERSIST is a cascading type in Hibernate that specifies that the create (or persist) operation should be cascaded 
 from the parent entity to the child entities.
 
 
 CascadeType.MERGE is a cascading type in Hibernate that specifies that the update (or merge) operation should be cascaded 
 from the parent entity to the child entities.
 When a detached Customer entity is merged back into the persistence context, any changes made to it will be automatically 
 merged with its associated Order entities.
 
 
 CascadeType.REMOVE is a cascading type in Hibernate that specifies that the delete operation should be cascaded from the parent  
 entity to the child entities.
 
 
 CascadeType.REFRESH is a cascading type in Hibernate that specifies that the refresh operation should be cascaded from the parent 
 entity to the child entities.
 When a Customer entity is refreshed, all associated Order entities will also be refreshed, and their state will be reloaded from the database.
 
 
 CascadeType.DETACH is a cascading type in Hibernate that specifies that the detach operation should be cascaded from the parent entity 
 to the child entities.
 When a Customer entity is detached from the persistence context, all associated Order entities will also be detached.
 
 
 CascadeType.REPLICATE is a cascading type in Hibernate that specifies that the replicate operation should be cascaded from 
 the parent entity to the child entities.
 When a Customer entity is replicated, new Order entities will be created and persisted with the same state as the original Order entities.
 
 
 CascadeType.SAVE_UPDATE is a cascading type in Hibernate that specifies that the save or update operation should be 
 cascaded from the parent entity to the child entities.
 When a Customer entity is saved or updated, any associated Order entities will also be saved or updated automatically.
 
 
  @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
 
 
 
 @OneToMany(orphanRemoval = true, mappedBy = "employee")
 private Set<AccountEntity> accounts;
 It essentially means that whenever I will remove an ‘account from accounts set’ (which means I am removing the relationship 
 between that account and Employee); the account entity which is not associated with any other Employee on the database 
 (i.e. orphan) should also be deleted.
 
 
 
 ****Note : There is no default cascade type in JPA. By default, no operation is cascaded.
 Use cascading very carefully. We shouldn’t default to CascadeType.ALL in case of many-to-many mapping because the 
 CascadeType.REMOVE might end-up deleting more than we’re expecting. for eg. we delete employee then all associated projects 
 will be deleted which might be associated with other employees. resulting in a massive entity deletion.
 
 
 To prevent StaleObjectStateException in Hibernate, 2 separate threads trying to update the same entities at the same time.
 
 
 */
