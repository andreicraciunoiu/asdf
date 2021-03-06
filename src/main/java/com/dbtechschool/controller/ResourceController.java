package com.dbtechschool.controller;

import com.dbtechschool.model.Resource;
import com.dbtechschool.service.ResourceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResourceController {

	@Autowired
	private ResourceService resourceService;

	@RequestMapping(value = "/resources", method = RequestMethod.GET)
	public List<Resource> listAllResource() {
		return resourceService.findAllResources();
	}
	
	@RequestMapping(value = "/resource/{id}", method = RequestMethod.GET)
	public Resource getById(@PathVariable(value = "id") Long id) {
		return resourceService.getById(id);
	}
	
	@RequestMapping(value = "/resources/section/{id}", method = RequestMethod.GET)
	public List<Resource> getDaysByCourse(@PathVariable(value = "id") Long id) {
		return resourceService.getResourcesBySectionId(id);
	}

	@RequestMapping(value = "/resource/{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable(value = "id") Long id) {
		resourceService.deleteById(id);
	}

	@RequestMapping(value = "/clear/resources", method = RequestMethod.DELETE)
	public void deleteAll() {
		resourceService.removeAll();
	}

	@RequestMapping(value = "/resource", method = RequestMethod.POST)
	public void insertResource(@RequestBody Resource r) {
		resourceService.insertResource(r);
	}

	@RequestMapping(value = "/resource/{id}", method = RequestMethod.PUT)
	public void updateResource(@RequestBody Resource r, @PathVariable(value = "id") Long id) {
		resourceService.updateResourceById(r.getName(), r.getLink(), id);
	}
}
