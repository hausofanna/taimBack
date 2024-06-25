package com.taimBack.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Task {
	
	public Task() {
		super();
	}

	public Task(int taskId, int userId, String taskTitle, String taskDescription, String taskCategory,
			String taskLocation, int taskTime, String state, List<User> userList) {
		super();
		this.taskId = taskId;
		this.userId = userId;
		this.taskTitle = taskTitle;
		this.taskDescription = taskDescription;
		this.taskCategory = taskCategory;
		this.taskLocation = taskLocation;
		this.taskTime = taskTime;
		this.state = state;
		this.userList = userList;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int taskId;
	private int userId;
	private String taskTitle;
	private String taskDescription;
	private String taskCategory;
	private String taskLocation;
	private int taskTime;
	private String state;
	
	

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

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

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	@OneToMany(mappedBy="user", fetch = FetchType.LAZY )
	  private List<User> userList;
	
}
