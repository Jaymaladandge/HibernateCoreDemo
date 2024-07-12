package com.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	
	private String userName;
	
	@OneToMany(fetch = FetchType.EAGER ,mappedBy = "user")		//If we dont use mappedBy one extra table for foreign key column will be created
	private List<Post> posts;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String userName, List<Post> posts) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.posts = posts;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", posts=" + posts + "]";
	}
	
	
	
	
}
