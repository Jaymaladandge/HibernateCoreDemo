package com.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private int empId;

	private String empName;

	@ManyToMany
	@JoinTable(name = "emp_project_info", joinColumns = { @JoinColumn(name = "emp_id") }, inverseJoinColumns = { @JoinColumn(name = "proj_id")})
	private List<Project> projects;  //@JoinTable is optional it use just to rename table and columns

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}


/*
  
  
  GenerationType.IDENTITY: This strategy relies on the auto-increment functionality provided by the database to 
  generate unique identifier values automatically.
  
  GenerationType.AUTO: This strategy lets the JPA provider choose the most appropriate strategy based on the underlying database and configuration. 
  It typically maps to either IDENTITY or SEQUENCE, depending on database capabilities.
  
  
 */






