package com.taimBack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.taimBack.entities.User;
import com.taimBack.persistence.UserRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin // Para hacer peticiones desde otro servidor
@RestController // Para hacer peticiones REST
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/")
	public void createUser(@RequestBody User user) {
		userRepository.save(user);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		User i = new User();
		i.setUserId(id);
		userRepository.delete(i);
	}

	@GetMapping("/")
	public List<User> selectUser() {
		List<User> users = userRepository.findAll();
		return users;
	}

	@PutMapping("/{id}")
	public void updateUser(@RequestBody User user, @PathVariable("id") Integer id) {
		user.setUserId(id);
		userRepository.save(user);
	}
}
