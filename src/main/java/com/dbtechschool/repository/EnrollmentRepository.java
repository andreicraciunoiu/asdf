package com.dbtechschool.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dbtechschool.model.Enrollment;

@Repository
public interface EnrollmentRepository extends CrudRepository<Enrollment, Long> {
	
	@Modifying
	@Transactional
	@Query(value = "insert into enrollments (id_course, id_user) Values (?1, ?2)", nativeQuery = true)
	int insertEnrollment(Long id_c, Long id_u);
}
