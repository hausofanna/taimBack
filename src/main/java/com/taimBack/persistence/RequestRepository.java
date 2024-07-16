package com.taimBack.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.taimBack.entities.Request;
import com.taimBack.entities.User;

public interface RequestRepository extends CrudRepository<Request, Integer>{
	List<Request> findAll();
	
	Request findById(int id);
}
