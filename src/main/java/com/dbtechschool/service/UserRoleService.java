package com.dbtechschool.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbtechschool.model.UserRole;
import com.dbtechschool.repository.UserRolesRepository;

@Service
public class UserRoleService {
	@Autowired
	private UserRolesRepository userRolesRepository;

	public List<UserRole> getAll() {
		List<UserRole> allUsers = new ArrayList<>();
		userRolesRepository.findAll().forEach(allUsers::add);
		return allUsers;
	}
}
