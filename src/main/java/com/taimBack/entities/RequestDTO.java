package com.taimBack.entities;

public class RequestDTO {
	
	private int id;
	private int status;
	private TaskDTO task;
	private UserDTO user;
	
	public RequestDTO() {
		super();
	}
	
	public RequestDTO(int id, int status, int userId, int taskId, TaskDTO task, UserDTO user) {
		super();
		this.id = id;
		this.status = status;
		this.task = task;
		this.user = user;
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

	public TaskDTO getTask() {
		return task;
	}

	public void setTask(TaskDTO task) {
		this.task = task;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
}
