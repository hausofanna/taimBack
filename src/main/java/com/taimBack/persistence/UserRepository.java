package com.taimBack.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.taimBack.entities.User;

import jakarta.transaction.Transactional;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	@Transactional
	List<User> findAll();

	@Transactional
	User findByUsername(String username);
	
	@Transactional
	User findById(int id);

}

