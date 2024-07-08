package com.taimBack.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taimBack.config.TaskService;
import com.taimBack.config.UserService;
import com.taimBack.entities.Task;
import com.taimBack.entities.TaskDTO;
import com.taimBack.persistence.TaskRepository;

@CrossOrigin
@RestController
@RequestMapping("/tasks")

public class TaskController {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private TaskService taskService;

	@PostMapping("/")
	public void createTask(@RequestBody Task task) {
		taskRepository.save(task);
	}

	@DeleteMapping("{id}")
	public void deleteTask(@PathVariable("id") Integer id) {
		Task t = new Task();
		t.setId(id);
		taskRepository.delete(t);
	}

//	@GetMapping("/")
//	public List<Task> selectTask() {
//		return taskRepository.findAll();
//	}
	
	@GetMapping("/")
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        List<TaskDTO> taskDTOs = taskService.getAllTasks();
        return ResponseEntity.ok(taskDTOs);
    }

	@PutMapping("/{id}")
	public void updateTask(@RequestBody Task task, @PathVariable("id") Integer id) {
		task.setId(id);
		taskRepository.save(task);
	}

}
