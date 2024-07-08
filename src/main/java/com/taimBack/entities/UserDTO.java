package com.taimBack.entities;

public class UserDTO {
	
	private String name, surname, username, email, password;

	public UserDTO(String name, String surname, String username, String email, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public UserDTO() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
