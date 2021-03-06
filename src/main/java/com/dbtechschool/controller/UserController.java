package com.dbtechschool.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dbtechschool.model.User;
import com.dbtechschool.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public List<User> getAll() {
		return userService.getAll();
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public User getById(@PathVariable(value = "id") Long id) {
		return userService.getById(id);
	}

	@RequestMapping(value = "/user/name/{username}", method = RequestMethod.GET)
	public User getByUsername(@PathVariable(value = "username") String username) {
		return userService.getByUsername(username);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable(value = "id") Long id) {
		userService.deleteById(id);
	}

	@RequestMapping(value = "/clear/user", method = RequestMethod.PUT)
	public void deleteAll() {
		userService.removeAll();
	}

	@RequestMapping(value = "/user/{role}", method = RequestMethod.POST)
	public void insertUser(@RequestBody User u, @PathVariable(value = "role") String role) {
		userService.insertUser(u, role);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public void updateUser(@RequestBody User u, @PathVariable(value = "id") Long id) {
		userService.updateUserbyId(u.getUsername(), u.getFirstName(), u.getLastName(), u.getEmail(), u.getPassword(),
				u.getEnabled(), u.getTags(), id);
	}
	
	@RequestMapping(value = "/user/{id}/{role}", method = RequestMethod.PUT)
	public void updateUserAndRole(@RequestBody User u, @PathVariable(value = "id") Long id, @PathVariable(value = "role") String role) {
		userService.updateUserAndRolebyId(u.getUsername(), u.getFirstName(), u.getLastName(), u.getEmail(), u.getPassword(),
				u.getEnabled(), u.getTags(), id, role);
	}
}
