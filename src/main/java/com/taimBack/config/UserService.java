package com.taimBack.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.taimBack.entities.User;
import com.taimBack.entities.UserDTO;
import com.taimBack.persistence.UserRepository;

@Service
public class UserService {

	@Autowired
	BCryptPasswordEncoder encoder;

	public UserDTO toUserDTO(User user) {
		if (user == null) {
			return null;
		}

		UserDTO userDTO = new UserDTO();
		userDTO.setName(user.getName());
		userDTO.setSurname(user.getSurname());
		userDTO.setUsername(user.getUsername());
		userDTO.setEmail(user.getEmail());
		userDTO.setPassword(user.getPassword());

		return userDTO;
	}

	public User toUser(UserDTO userDTO) {
		if (userDTO == null) {
			return null;
		}

		User user = new User();
		user.setName(userDTO.getName());
		user.setSurname(userDTO.getSurname());
		user.setUsername(userDTO.getUsername());
		String encryptedPassword = encoder.encode(userDTO.getPassword());
		user.setPassword(encryptedPassword);
		user.setEmail(userDTO.getEmail());

		return user;
	}
}
