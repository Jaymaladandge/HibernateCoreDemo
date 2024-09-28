package com.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proj_id")
	private int projectId;
	
	private String projectName;
	
	@ManyToMany(mappedBy = "projects")    //It will not create separate table of foreign keys, will refer table created by "projects" field of Employee 
	private List<Employee> emps;
	
	

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
	
	
}



/*
 
 If you do not use the @ManyToMany(mappedBy = "projects") annotation in the Project class, JPA will treat the relationship as two separate 
 one-to-many relationships instead of a many-to-many relationship. In this scenario, it would create an additional join table for the 
 relationship.
 tables : 1]Employee, 
 2]Project, 
 3]emp_project_info : emp_id (Foreign Key referencing Employee)
 proj_id (Foreign Key referencing Project), 
 4]project_employee : (assuming JPA interprets it as a separate relationship. proj_id (Foreign Key referencing Project)
 emp_id (Foreign Key referencing Employee))  
 
  
  
  
  
  
  
  
  
  
  
  
  
  */









