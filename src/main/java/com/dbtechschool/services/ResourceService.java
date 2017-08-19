package com.dbtechschool.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbtechschool.models.Resource;
import com.dbtechschool.repositories.ResourceRepository;

@Service
public class ResourceService {

	@Autowired
	ResourceRepository resourceRepository;

	public List<Resource> findAllCourses() {
		return ((List<Resource>) resourceRepository.findAll());
	}

}
