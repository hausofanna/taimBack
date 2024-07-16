package com.taimBack.controllers;

import java.util.List;
import java.util.Optional;
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
import com.taimBack.entities.UserDTO;
import com.taimBack.persistence.TaskRepository;

@CrossOrigin
@RestController
@RequestMapping("/tasks")

public class TaskController {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private TaskService taskService;

	@GetMapping
	public List<TaskDTO> getAllTasks() {
		List<Task> tasks = taskRepository.findAll();
		return tasks.stream().map(taskService::toTaskDTO).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public TaskDTO getTaskById(@PathVariable Integer id) {
		Task task = taskRepository.findById(id).orElse(null);
		return taskService.toTaskDTO(task);
	}

	@PostMapping
	public TaskDTO createTask(@RequestBody TaskDTO taskDTO) {
		Task task = taskService.toTask(taskDTO);
		task = taskRepository.save(task);
		return taskService.toTaskDTO(task);
	}
	
	 @PutMapping("/{id}")
	    public TaskDTO updateTask(@PathVariable Integer id, @RequestBody TaskDTO taskDTO) {
	        Optional<Task> taskOptional = taskRepository.findById(id);
	        if (taskOptional.isPresent()) {
	        	 Task task = taskOptional.get();
	        	task.setId(taskDTO.getId());
				task.setTitle(taskDTO.getTitle());
				task.setDescription(taskDTO.getDescription());
				task.setCategory(taskDTO.getCategory());
				task.setLocation(taskDTO.getLocation());
				task.setDate(taskDTO.getDate());
				task.setState(taskDTO.getState());
				task.setHours(taskDTO.getHours());
				task.setUser(taskService.toTask(taskDTO).getUser());
				task = taskRepository.save(task);
				return taskService.toTaskDTO(task);
	        } else {
	            return null; // O lanza una excepción personalizada
	        }
	    }

	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Integer id) {
		taskRepository.deleteById(id);
	}

}
