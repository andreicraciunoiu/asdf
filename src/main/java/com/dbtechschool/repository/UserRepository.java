package com.dbtechschool.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dbtechschool.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	@Modifying
	@Transactional
	@Query("update User u set u.username = ?1, u.firstName = ?2, u.lastName = ?3, u.email = ?4, u.password = ?5, u.type = ?6  where u.id = ?7")
	int updateUserbyId(String username, String firstName, String lastName, String email, String password, char type,
			Long id);

}
