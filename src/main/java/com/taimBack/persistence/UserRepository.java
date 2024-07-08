package com.taimBack.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.taimBack.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	List<User> findAll();

	User findByUsername(String username);
	
	User findById(int id);

}

