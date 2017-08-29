package com.dbtechschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dbtechschool.model.UserRole;

public interface UserRolesRepository extends CrudRepository<UserRole, Long> {
	
	@Query("SELECT ur.role FROM UserRole ur, User u WHERE u.username=?1 AND ur.user.id=u.id")
	public List<String> findRoleByUserName(String username);
}
