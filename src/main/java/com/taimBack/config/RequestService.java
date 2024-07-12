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
	    public List<RequestDTO> getAllRequests() {
	        List<Request> request = requestRepository.findAll();
	        return request.stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }

	    private RequestDTO convertToDTO(Request request) {
	    	RequestDTO requestDTO = new RequestDTO();
	    	requestDTO.setId(request.getId());
	    	requestDTO.setStatus(request.getStatus()); 
	        if (request.getUser() != null) {
	        	requestDTO.setUserId(request.getUser().getId());
	        	requestDTO.setTaskId(request.getTask().getId()); 
	        }

	        return requestDTO;
	    }
}
