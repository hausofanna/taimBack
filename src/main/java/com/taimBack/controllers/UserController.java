package com.taimBack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taimBack.entities.User;
import com.taimBack.persistence.UserRepository;

@CrossOrigin // Para hacer peticiones desde otro servidor
@RestController // Para hacer peticiones REST
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	BCryptPasswordEncoder encoder;

	@PostMapping("/")
	public void createUser(@RequestBody User user) {
		String encryptedPassword = encoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		userRepository.save(user);
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		User i = new User();
		i.setId(id);
		userRepository.delete(i);
	}

	@GetMapping("/")
	public List<User> selectUser() {
		List<User> users = userRepository.findAll();
		return users;
	}

	@PutMapping("/{id}")
	public void updateUser(@RequestBody User user, @PathVariable("id") Integer id) {
		user.setId(id);
		userRepository.save(user);
	}
}
