package com.taimBack.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taimBack.entities.Task;
import com.taimBack.entities.TaskDTO;
import com.taimBack.entities.User;
import com.taimBack.entities.UserDTO;

@Service
public class TaskService {

    @Autowired
    private UserService userService;

    public TaskDTO toTaskDTO(Task task) {
        if (task == null) {
            return null;
        }
        
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setCategory(task.getCategory());
        taskDTO.setLocation(task.getLocation());
        taskDTO.setDate(task.getDate());
        taskDTO.setState(task.getState());
        taskDTO.setHours(task.getHours());
        User originalUser = task.getUser();
        UserDTO dtoUser = userService.toUserDTO(originalUser);
        
        taskDTO.setUser(dtoUser);

        return taskDTO;
    }

    public Task toTask(TaskDTO taskDTO) {
        if (taskDTO == null) {
            return null;
        }

        Task task = new Task();       
        task.setId(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setCategory(taskDTO.getCategory());
        task.setLocation(taskDTO.getLocation());
        task.setDate(taskDTO.getDate());
        task.setState(taskDTO.getState());
        task.setHours(taskDTO.getHours());
        
        User user = new User();
        user.setId(taskDTO.getUser().getId());
        task.setUser(user);

        return task;
    }
}
