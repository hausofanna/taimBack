package com.taimBack.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.taimBack.entities.Task;
import com.taimBack.entities.User;

public interface TaskRepository extends CrudRepository<Task, Integer> {
	List<Task> findAll();
	
	Task findById(int id);
}
