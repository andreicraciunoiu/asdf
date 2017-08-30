package com.dbtechschool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbtechschool.model.UserRole;
import com.dbtechschool.service.UserRoleService;


@RestController
public class UserRoleController {

		@Autowired
		private UserRoleService userService;
		
		@RequestMapping(value = "/usersrole", method = RequestMethod.GET)
		public List<UserRole> getAll() {
			return userService.getAll();
		}
		
		
}
