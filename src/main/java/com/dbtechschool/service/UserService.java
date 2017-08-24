package com.dbtechschool.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbtechschool.models.User;
import com.dbtechschool.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAll() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	public User getById(Long id) {
		return userRepository.findOne(id);
	}

	public void deleteById(Long id) {
		userRepository.delete(id);
	}

	public void removeAll() {
		userRepository.deleteAll();
	}

	public void insertUser(User newUser) {
		userRepository.save(newUser);
	}

	public void updateUserbyId(String username, String firstName, String lastName, String email, String password,
			char type, Long id) {
		// TODO Auto-generated method stub
		userRepository.updateUserbyId(username, firstName, lastName, email, password, type, id);
	}
}