//package com.practice.domain;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.Cascade;
//
//
//@Entity
//@Table(name="Users")
//public class Users {
//	
//	@Id
//	@Column(name="user_id")
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private int id;
//	private String firstname;
//	private String lastname;
//	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)//,fetch=FetchType.EAGER)
//	private List <Tasks> task;
//	
//	public List<Tasks> getTask() {
//		return task;
//	}
//
//	public void setTask(List<Tasks> task) {
//		this.task = task;
//	}
//
//	public Users() {
//	}
//		
//	public Users(String firstname, String lastname) {
//		this.firstname = firstname;
//		this.lastname = lastname;
//	}
//
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getFirstname() {
//		return firstname;
//	}
//	public void setFirstname(String firstname) {
//		this.firstname = firstname;
//	}
//	public String getLastname() {
//		return lastname;
//	}
//	public void setLastname(String lastname) {
//		this.lastname = lastname;
//	}
//		
//}
