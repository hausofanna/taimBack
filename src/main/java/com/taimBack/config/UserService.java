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
    private UserRepository userRepository;
    
    @Autowired
	BCryptPasswordEncoder encoder;

    public User saveUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setUsername(userDTO.getUsername());
        String encryptedPassword = encoder.encode(userDTO.getPassword());
		user.setPassword(encryptedPassword);
        user.setEmail(userDTO.getEmail());
        return userRepository.save(user);
    }
    
}

