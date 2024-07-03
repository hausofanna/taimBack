package com.taimBack.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> createUser(@RequestBody User user) {
		String encryptedPassword = encoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		userRepository.save(user);
		
		return ResponseEntity.ok().body("{\"resp\":\"Usuario creado correctamente\"}");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
		User i = new User();
		i.setId(id);
		userRepository.delete(i);
		
		return ResponseEntity.ok().body("{\"resp\":\"Usuario eliminado correctamente\"}");
	}

	@GetMapping("/")
	public List<User> selectUser() {
		List<User> users = userRepository.findAll();
		return users;
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") Integer id) {
		Optional<User> users = userRepository.findById(id);
		return users.orElse(null);
	}
	

	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable("id") Integer id) {
		user.setId(id);
		userRepository.save(user);
		
		return ResponseEntity.ok().body("{\"resp\":\"Usuario cambiado correctamente\"}");
	}
}
