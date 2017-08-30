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
	@Query("update User u set u.username = ?1, u.firstName = ?2, u.lastName = ?3, u.email = ?4, u.password = ?5, u.enabled = ?6, u.tags = ?7 where u.id = ?8")
	int updateUserbyId(String username, String firstName, String lastName, String email, String password, int enabled, String tags, Long id);
	
	public User findByUsername(String username);

	@Modifying
	@Transactional
	@Query(value = "insert into user_roles (id_user, role) values (?1, ?2)", nativeQuery = true)
	int insertUserRole(Long id, String role);

//	@Transactional
//	@Query(value = "select u.*, ur.role from users u, user_roles ur where u.id_user=ur.id_user", nativeQuery = true)
//	Object[] getUsersAndRoles();
	
	@Modifying
	@Transactional
	@Query("update UserRole ur set ur.role = ?1 where ur.user.id = ?2")
	int updateUserRolebyId(String role, Long id);
	
	@Modifying
	@Transactional
	@Query(value = "delete from user_roles where id_user=?1", nativeQuery = true)
	int deleteRole(Long id);
	

}
