package com.taimBack.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taimBack.entities.Request;
import com.taimBack.entities.RequestDTO;
import com.taimBack.entities.Task;
import com.taimBack.entities.User;
import com.taimBack.entities.UserDTO;

@Service
public class RequestService {

//	    @Transactional(readOnly = true)
//	    public List<RequestDTO> getAllRequests() {
//	        List<Request> request = requestRepository.findAll();
//	        return request.stream()
//	                .map(this::convertToDTO)
//	                .collect(Collectors.toList());
//	    }

	  @Autowired
	    private UserService userService;

	    @Autowired
	    private TaskService taskService;

	    public RequestDTO toRequestDTO(Request request) {
	        if (request == null) {
	            return null;
	        }

	        RequestDTO requestDTO = new RequestDTO();
	        requestDTO.setId(request.getId());
	        requestDTO.setStatus(request.getStatus());
	        requestDTO.setUserId(request.getUser().getId());
	        requestDTO.setUsername(request.getUser().getUsername());
	        requestDTO.setEmail(request.getUser().getEmail());
	        requestDTO.setDescription(request.getUser().getDescription());
	        requestDTO.setTaskId(request.getTask().getId());
	        requestDTO.setTitle(request.getTask().getTitle());
	        requestDTO.setHours(request.getTask().getHours());
	        //requestDTO.setUser(userService.toUserDTO(request.getUser()));
	        //requestDTO.setTask(taskService.toTaskDTO(request.getTask()));

	        return requestDTO;
	    }

	    public Request toRequest(RequestDTO requestDTO) {
	        if (requestDTO == null) {
	            return null;
	        }

	        Request request = new Request();
	        request.setId(requestDTO.getId());
	        request.setStatus(requestDTO.getStatus());
	        
	        User user = new User();
	        user.setId(requestDTO.getUserId());
	        request.setUser(user);
	        
	        Task task = new Task();
	        task.setId(requestDTO.getTaskId());
	        request.setTask(task);

	        return request;
	    }
}
