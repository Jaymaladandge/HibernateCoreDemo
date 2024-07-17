package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ans_id")
	private int ansId;

	private String ans;

	//@OneToOne   //This is for bi-directional mapping. with mappedBy = "answer" property we are telling to 
	//private Question question;	//	not generate foreign key within answer table, refer foreign key from question table from answer column

	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Answer(int id, String answer) {
		super();
		this.ansId = id;
		this.ans = answer;
	}

	public String getAnswer() {
		return ans;
	}

	public void setAnswer(String answer) {
		this.ans = answer;
	}

	public int getAnsId() {
		return ansId;
	}

	public void setAnsId(int ansId) {
		this.ansId = ansId;
	}

	@Override
	public String toString() {
		return "Answer [ansId=" + ansId + ", ans=" + ans + "]";
	}

	 
	/*
	 * public Question getQuestion() { return question; }
	 * 
	 * public void setQuestion(Question question) { this.question = question; }
	 * 
	 * 
	 * 
	 * @Override public String toString() { return "Answer [ansId=" + ansId +
	 * ", answer=" + ans + ", question=" + question + "]"; }
	 */

	
}
