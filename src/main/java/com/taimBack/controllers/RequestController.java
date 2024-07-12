package com.taimBack.controllers;

import java.util.List;

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

import com.taimBack.config.RequestService;
import com.taimBack.config.TaskService;
import com.taimBack.entities.Request;
import com.taimBack.entities.RequestDTO;
import com.taimBack.entities.TaskDTO;
import com.taimBack.persistence.RequestRepository;

@CrossOrigin
@RestController
@RequestMapping("/requests")
public class RequestController {
	
	@Autowired
	private RequestRepository requestRepository;
	
	@Autowired
	private RequestService requestService;
	
	@PostMapping("/")
	public void createRequest(@RequestBody Request request) {
		requestRepository.save(request);
	}
	
	@DeleteMapping("/{id}")
	public void deleteRequest(@PathVariable("id") Integer id) {
		Request r = new Request();
		r.setId(id);
		requestRepository.delete(r);
	}
	
//	@GetMapping("/")
//	public List<Request> selectTask() {
//	return requestRepository.findAll();
//	}
	
	@GetMapping("/")
    public ResponseEntity<List<RequestDTO>> getAllRequests() {
        List<RequestDTO> requestDTO = requestService.getAllRequests();
        return ResponseEntity.ok(requestDTO);
    }
	
	@PutMapping("/{id}")
	public void updateRequest(@RequestBody Request request, @PathVariable("id") Integer id) {
		request.setId(id);
		requestRepository.save(request);
	}

}
