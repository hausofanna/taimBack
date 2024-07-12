package com.taimBack.entities;

public class RequestDTO {
	
	private int id;
	private int status;
	private int userId;
	private int taskId;
	
	public RequestDTO() {
		super();
	}
	
	public RequestDTO(int id, int status, int userId, int taskId) {
		super();
		this.id = id;
		this.status = status;
		this.userId = userId;
		this.taskId = taskId;
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
	
}
