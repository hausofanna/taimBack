package com.taimBack.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taimBack.entities.Request;
import com.taimBack.entities.RequestDTO;
import com.taimBack.persistence.RequestRepository;

@Service
public class RequestService {

	 @Autowired
	    private RequestRepository requestRepository;

	    @Transactional(readOnly = true)
	    public List<RequestDTO> getAllTasks() {
	        List<Request> tasks = requestRepository.findAll();
	        return tasks.stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }

	    private RequestDTO convertToDTO(Request request) {
	    	RequestDTO requestDTO = new RequestDTO();
//	        taskDTO.setId(task.getId());
//	        taskDTO.setTitle(task.getTitle());
//	        taskDTO.setDescription(task.getDescription());
//	        taskDTO.setCategory(task.getCategory());
//	        taskDTO.setLocation(task.getLocation());
//	        taskDTO.setDate(task.getDate());
//	        taskDTO.setState(task.getState());
//	        taskDTO.setHours(task.getHours());
//	        if (task.getUser() != null) {
//	            taskDTO.setUserId(task.getUser().getId());
//	            taskDTO.setUsername(task.getUser().getUsername()); 
//	        }

	        return requestDTO;
	    }
}
