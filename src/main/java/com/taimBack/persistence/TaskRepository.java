package com.taimBack.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.taimBack.entities.Task;
import com.taimBack.entities.User;

import jakarta.transaction.Transactional;

public interface TaskRepository extends CrudRepository<Task, Integer> {
	
	@Transactional
	List<Task> findAll();
	
	@Transactional
	Task findById(int id);
}
