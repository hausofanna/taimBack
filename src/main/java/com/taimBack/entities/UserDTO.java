package com.taimBack.entities;

import jakarta.annotation.Nullable;

public class UserDTO {

	private String name, surname, username, email, password;
	private int id;
	@Nullable
	private String location;

	@Nullable
	private String description;

	@Nullable
	private String skills;

	@Nullable
	private String interests;

	private int rating;

	public UserDTO(String name, String surname, String username, String email, String password, int id,
			String location, String description, String skills, String interests, int rating) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.email = email;
		this.password = password;
		this.location = location;
		this.description = description;
		this.skills = skills;
		this.interests = interests;
		this.rating = rating;
		}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
