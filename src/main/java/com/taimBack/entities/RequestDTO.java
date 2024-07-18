package com.taimBack.entities;

public class RequestDTO {
	
	private int id;
	private int status;
	private int userId;
	private int taskId;
//	private TaskDTO task;
//	private UserDTO user;
	
	public RequestDTO() {
		super();
	}
	
	public RequestDTO( int status, int userId, int taskId) {
		super();
//		this.id = id;
		this.status = status;
		this.userId = userId;
		this.taskId = taskId;
//		this.task = task;
//		this.user = user;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	

//	public TaskDTO getTask() {
//		return task;
//	}
//
//	public void setTask(TaskDTO task) {
//		this.task = task;
//	}
//
//	public UserDTO getUser() {
//		return user;
//	}
//
//	public void setUser(UserDTO user) {
//		this.user = user;
//	}
//	
}
