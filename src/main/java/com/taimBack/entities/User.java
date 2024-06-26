package com.taimBack.entities;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

	public User(int userId, String name, String surname,String nickname, String email, String password, Date birthday, String location,
			String description, String habilities, String interests, int rating, String profilePict) {
		super();
		this.userId = userId;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.birthday = birthday;
		this.location = location;
		this.description = description;
		this.habilities = habilities;
		this.interests = interests;
		this.rating = rating;
		this.profilePict = profilePict;
	}
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public User() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String name;
	private String surname;
	private String email;
	private String nickname;
	private String password;
	private Date birthday;
	@Nullable
	private String location;
	@Nullable
	private String description;
	@Nullable
	private String habilities;
	@Nullable
	private String interests;
	@Value("${some.key:0}")
	private int rating;
	@Nullable
	private String profilePict;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHabilities() {
		return habilities;
	}
	public void setHabilities(String habilities) {
		this.habilities = habilities;
	}
	public String getInterests() {
		return interests;
	}
	public void setInterests(String interests) {
		this.interests = interests;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getProfilePict() {
		return profilePict;
	}
	public void setProfilePict(String profilePict) {
		this.profilePict = profilePict;
	}

}
