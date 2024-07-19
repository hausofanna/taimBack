package com.taimBack.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

import com.taimBack.config.UserService;
import com.taimBack.entities.User;
import com.taimBack.entities.UserDTO;
import com.taimBack.persistence.UserRepository;

@CrossOrigin // Para hacer peticiones desde otro servidor
@RestController // Para hacer peticiones REST
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;

//	@Autowired
//	BCryptPasswordEncoder encoder;

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public List<UserDTO> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users.stream().map(userService::toUserDTO).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public UserDTO getUserById(@PathVariable Integer id) {
		Optional<User> user = userRepository.findById(id);
		return user.map(userService::toUserDTO).orElse(null);
	}

	@PostMapping("/")
	public UserDTO createUser(@RequestBody UserDTO userDTO) {
		User user = userService.toUser(userDTO);
		user = userRepository.save(user);
		return userService.toUserDTO(user);
	}

	@PutMapping("/{id}")
	public UserDTO updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
		Optional<User> userOptional = userRepository.findById(id);
		if (userOptional.isPresent()) {
			User user = userOptional.get();
			user.setUsername(userDTO.getUsername());
			user.setName(userDTO.getName());
			user.setSurname(userDTO.getSurname());
			user.setEmail(userDTO.getEmail());
			user.setLocation(userDTO.getLocation());
			user.setDescription(userDTO.getDescription());
			user.setSkills(userDTO.getSkills());
			user.setInterests(userDTO.getInterests());
			user.setRating(userDTO.getRating());
			user = userRepository.save(user);
			return userService.toUserDTO(user);
		} else {
			return null;
		}
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userRepository.deleteById(id);
	}
}
