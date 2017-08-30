package com.dbtechschool.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbtechschool.model.User;
import com.dbtechschool.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAll() {
		return (List<User>) userRepository.findAll();
	}

	public User getById(Long id) {
		return userRepository.findOne(id);
	}

	public void deleteById(Long id) {
		userRepository.deleteRole(id);
		userRepository.delete(id);
	}

	public void removeAll() {
		userRepository.deleteAll();
	}

	public void insertUser(User newUser, String role) {
		userRepository.save(newUser);
		userRepository.insertUserRole(newUser.getId(), role);
	}

	public void updateUserbyId(String username, String firstName, String lastName, String email, String password,
			int enabled, String tags, Long id) {
		// TODO Auto-generated method stub
		userRepository.updateUserbyId(username, firstName, lastName, email, password, enabled, tags, id);
	}

	public void updateUserAndRolebyId(String username, String firstName, String lastName, String email, String password,
			int enabled, String tags, Long id, String role) {
		// TODO Auto-generated method stub
		userRepository.updateUserbyId(username, firstName, lastName, email, password,
				enabled, tags, id);
		userRepository.updateUserRolebyId(role, id);
		
	}
}
