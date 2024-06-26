package com.taimBack.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat; 

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String state;
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime dateTime;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Task task;

	@OneToMany(mappedBy = "request", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<User> users;


	public Request() {
		super();
	}

	public Request(String state, LocalDateTime dateTime, Task task, List<User> users) {
		super();
		this.state = state;
		this.dateTime = dateTime;
		this.task = task;
		this.users = users;
	}

	public Request(int id, String state, LocalDateTime dateTime, Task task, List<User> users) {
		super();
		this.id = id;
		this.state = state; 
		this.dateTime = dateTime;
		this.task = task;
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
