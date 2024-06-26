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

import com.taimBack.entities.Request;
import com.taimBack.persistence.RequestRepository;

@CrossOrigin 
@RestController 
@RequestMapping("/event")
public class RequestController {
	@Autowired
	private RequestRepository requestRepository;	
	
	@PostMapping("/")
	public void createEvent(@RequestBody Request request) {
		requestRepository.save(request);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEvent(@PathVariable("id") Integer id) {
		Request e = new Request();
		e.setId(id);
		requestRepository.delete(e);
	}
	
	@GetMapping("/")
	public List<Request> selectEvent(){
		return requestRepository.findAll();
	}
	
	@PutMapping("/{id}")
	public void updateEvent(@RequestBody Request request,@PathVariable("id")Integer id) {
		request.setId(id);
		requestRepository.save(request);
	}
}