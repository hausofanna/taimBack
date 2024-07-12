package com.taimBack.entities;

public class RequestDTO {
	
	private int id;
	private int status;
	private User user;
	private Task task;
	
	public RequestDTO() {
		super();
	}
	
	public RequestDTO(int id, int status, User user, Task task) {
		super();
		this.id = id;
		this.status = status;
		this.user = user;
		this.task = task;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	
}
