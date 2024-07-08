package com.taimBack.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.taimBack.entities.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {
	List<Task> findAll();
}
