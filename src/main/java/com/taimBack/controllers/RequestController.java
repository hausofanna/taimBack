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

	@GetMapping
	public List<RequestDTO> getAllRequests() {
		List<Request> requests = requestRepository.findAll();
		return requests.stream().map(requestService::toRequestDTO).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public RequestDTO getRequestById(@PathVariable Integer id) {
		Request request = requestRepository.findById(id).orElse(null);
		return requestService.toRequestDTO(request);
	}

	@PostMapping
	public RequestDTO createRequest(@RequestBody RequestDTO requestDTO) {
		Request request = requestService.toRequest(requestDTO);
		request = requestRepository.save(request);
		return requestService.toRequestDTO(request);
	}

	@PutMapping("/{id}")
	public RequestDTO updateRequest(@PathVariable Integer id, @RequestBody RequestDTO requestDTO) {
		Optional<Request> requestOptional = requestRepository.findById(id);
		if (requestOptional.isPresent()) {
			Request request = requestOptional.get();
			request.setStatus(requestDTO.getStatus());
			request.setUser(requestService.toRequest(requestDTO).getUser());
			request.setTask(requestService.toRequest(requestDTO).getTask());
			request = requestRepository.save(request);
			return requestService.toRequestDTO(request);
		} else {
			return null; // O lanza una excepción personalizada
		}
	}

	@DeleteMapping("/{id}")
	public void deleteRequest(@PathVariable Integer id) {
		requestRepository.deleteById(id);
	}

}
