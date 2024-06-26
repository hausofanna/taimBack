package com.taimBack.entities;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
//	private int userId;
	private String title;
	private String description;
	private String category;
	private String location;
	private Date date;
	private String state;
	private int horas;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	public Task() {
		super();
	}

	public Task(int id, String title, String description, String category, String location, Date date, String state,
			int horas, User user) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.category = category;
		this.location = location;
		this.date = date;
		this.state = state;
		this.horas = horas;
		this.user = user;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	
}
