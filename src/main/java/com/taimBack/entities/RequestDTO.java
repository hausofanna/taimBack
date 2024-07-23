package com.taimBack.entities;

public class RequestDTO {
	
	private int id;
	private int status;
	private int userId;
	private int taskId;
	private String username;
	private String email;
	private String title;
	private String description;
	private String hours;
//	private TaskDTO task;
//	private UserDTO user;
	
	public RequestDTO() {
		super();
	}
	
	public RequestDTO( int status, int userId, int taskId, String username, String email, String title, 
			String description, String hours) {
		super();
//		this.id = id;
		this.status = status;
		this.userId = userId;
		this.taskId = taskId;
		this.username = username;
		this.email = email;
		this.title = title;
		this.description = description;
		this.hours = hours;
//		this.task = task;
//		this.user = user;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
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
