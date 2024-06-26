package com.taimBack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taimBack.entities.Task;

@CrossOrigin
@RestController
@RequestMapping("/tasks")

public class TaskController {

	@Autowired
	private TaskRepository taskRepository;
	
	@PostMapping("/")
	public void createTask(@RequestBody Task task) {
		taskRepository.save(task);
	}
	
	@DeleteMapping("{id}")
	public void deleteTask(@PathVariable("id") Integer id) {
		Task t = new Task();
		t.setTaskId(id);
		taskRepository.delete(t);
	}
	
	@GetMapping("/")
	public List<Task> selectTask(){
		return taskRepository.findAll();
	}
	
	@PutMapping("/{id}")
	public void updateTask(@RequestBody Task task, @PathVariable("id") Integer id) {
		task.setTaskId(id);
		taskRepository.save(task);
	}
	
}
