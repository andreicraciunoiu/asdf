package com.dbtechschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbtechschool.model.Resource;
import com.dbtechschool.repository.ResourceRepository;

@Service
public class ResourceService {

	@Autowired
	private ResourceRepository resourceRepository;

	public List<Resource> findAllResources() {
		return ((List<Resource>) resourceRepository.findAll());
	}

	public Resource getById(Long id) {
		return resourceRepository.findOne(id);
	}

	public void deleteById(Long id) {
		resourceRepository.delete(id);
	}

	public void removeAll() {
		resourceRepository.deleteAll();
	}

	public void insertResource(Resource newResource) {
		resourceRepository.save(newResource);
	}

	public void updateResourceById(String name, String link, Long id) {
        resourceRepository.updateResourceById(name, link, id);
    }
}
