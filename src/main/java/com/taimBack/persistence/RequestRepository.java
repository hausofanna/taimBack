package com.taimBack.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.taimBack.entities.Request;

import jakarta.transaction.Transactional;

public interface RequestRepository extends CrudRepository<Request, Integer>{
	
	@Transactional
	List<Request> findAll();
	
	@Transactional
	Request findById(int id);
}
