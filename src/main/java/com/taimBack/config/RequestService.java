package com.taimBack.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taimBack.entities.Request;
import com.taimBack.entities.RequestDTO;

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
	        requestDTO.setUser(userService.toUserDTO(request.getUser()));
	        requestDTO.setTask(taskService.toTaskDTO(request.getTask()));

	        return requestDTO;
	    }

	    public Request toRequest(RequestDTO requestDTO) {
	        if (requestDTO == null) {
	            return null;
	        }

	        Request request = new Request();
	        request.setId(requestDTO.getId());
	        request.setStatus(requestDTO.getStatus());
	        request.setUser(userService.toUser(requestDTO.getUser()));
	        request.setTask(taskService.toTask(requestDTO.getTask()));

	        return request;
	    }
}
