package com.taimBack.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.taimBack.entities.Request;

public interface RequestRepository  extends CrudRepository<Request, Integer>{

	List<Request> findAll();

}
