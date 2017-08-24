package com.dbtechschool.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbtechschool.model.User;
import com.dbtechschool.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> getAll() {
		return userService.getAll();
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public User getById(@PathVariable(value = "id") Long id) {
		return userService.getById(id);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable(value = "id") Long id) {
		userService.deleteById(id);
	}

	@RequestMapping(value = "/clear/users", method = RequestMethod.DELETE)
	public void deleteAll() {
		userService.removeAll();
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public void insertUser(@RequestBody User u) {
		userService.insertUser(u);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public void updatetUser(@RequestBody User u, @PathVariable(value = "id") Long id) {
		userService.updateUserbyId(u.getUsername(), u.getFirstName(), u.getLastName(), u.getEmail(), u.getPassword(),
				u.getType(), id);
	}
}
