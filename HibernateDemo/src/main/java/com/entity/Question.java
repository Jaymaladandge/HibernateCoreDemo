package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ques_id")
	private int quesId;

	private String question;

	@OneToOne(cascade = CascadeType.ALL)
	//@Cascade(CascadeType.ALL)
	@JoinColumn(name = "ans_id")
	private Answer answer;

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(int quesId, String question, Answer answer) {
		super();
		this.quesId = quesId;
		this.question = question;
		this.answer = answer;
	}

	public int getQuesId() {
		return quesId;
	}

	public void setQuesId(int quesId) {
		this.quesId = quesId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
 
	@Override
	public String toString() {
		return "Question [quesId=" + quesId + ", question=" + question + ", answer=" + answer + "]";
	}

}


//Two tables will be created one is Question and other is Answer. 
//In a @OneToOne relationship, whether it is unidirectional or bidirectional, only two tables are created.

