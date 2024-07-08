package com.taimBack.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taimBack.entities.Task;
import com.taimBack.entities.TaskDTO;
import com.taimBack.persistence.TaskRepository;


@Service
public class TaskService {


    @Autowired
    private TaskRepository taskRepository;

    @Transactional(readOnly = true)
    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private TaskDTO convertToDTO(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setCategory(task.getCategory());
        taskDTO.setLocation(task.getLocation());
        taskDTO.setDate(task.getDate());
        taskDTO.setState(task.getState());
        taskDTO.setHours(task.getHours());
        if (task.getUser() != null) {
            taskDTO.setUserId(task.getUser().getId());
            taskDTO.setUsername(task.getUser().getUsername()); 
        }

        return taskDTO;
    }
}
