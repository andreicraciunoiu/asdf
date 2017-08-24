package com.dbtechschool.controllers;

import com.dbtechschool.models.Resource;
import com.dbtechschool.services.ResourceService;
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
	public Resource getById(@PathVariable(value = "id") Integer id) {
		return resourceService.getById(id);
	}

	@RequestMapping(value = "/resource/{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable(value = "id") Integer id) {
		resourceService.deleteById(id);
	}

	@RequestMapping(value = "/clear/resources", method = RequestMethod.DELETE)
	public void deleteAll() {
		resourceService.removeAll();
	}

	@RequestMapping(value = "/resource", method = RequestMethod.POST)
	public void insertResource(@RequestBody Resource c) {
		resourceService.insertResource(c);
	}

	@RequestMapping(value = "/resource/{id}", method = RequestMethod.PUT)
	public void updateResource(@RequestBody Resource c, @PathVariable(value = "id") int id) {
		resourceService.updateResourceById(c.getName(), c.getLink(), id);
	}
}
