package com.taimBack.entities;

import java.util.Date;

public class TaskDTO {

	public TaskDTO() {
		super();
	}
	
	public TaskDTO(int id, String title, String description, String category, String location, Date date, String state,
			String hours, int userId, String username, UserDTO user) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.category = category;
		this.location = location;
		this.date = date;
		this.state = state;
		this.hours = hours;
		this.userId = userId;
		this.username = username;
		this.user = user;
	}



	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}



	private int id;
	private String title;
	private String description;
	private String category;
	private String location;
	private Date date;
	private String state;
	private String hours;
	
	private UserDTO user;

	private int userId;
	private String username;

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

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
