package com.taimBack.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
//	private int userId;
	private String taskTitle;
	private String taskDescription;
	private String taskCategory;
	private String taskLocation;
	private int taskTime;
	private String state;
	
	public Task() {
		super();
	}

	public Task(int id, String taskTitle, String taskDescription, String taskCategory,
			String taskLocation, int taskTime, String state, User user) {
		super();
		this.id = id;
//		this.userId = userId;
		this.taskTitle = taskTitle;
		this.taskDescription = taskDescription;
		this.taskCategory = taskCategory;
		this.taskLocation = taskLocation;
		this.taskTime = taskTime;
		this.state = state;
		this.user = user;
	}
	
	@ManyToOne
//	@JoinColumn(name = "userId")
	private User user;

	

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getTaskCategory() {
		return taskCategory;
	}

	public void setTaskCategory(String taskCategory) {
		this.taskCategory = taskCategory;
	}

	public String getTaskLocation() {
		return taskLocation;
	}

	public void setTaskLocation(String taskLocation) {
		this.taskLocation = taskLocation;
	}

	public int getTaskTime() {
		return taskTime;
	}

	public void setTaskTime(int taskTime) {
		this.taskTime = taskTime;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
