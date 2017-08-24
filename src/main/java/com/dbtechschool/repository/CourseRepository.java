package com.dbtechschool.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dbtechschool.model.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

	@Modifying
	@Transactional
	@Query("update Course c set c.name = ?1, c.start = ?2, c.end = ?3, c.tags = ?4, c.description = ?5, c.difficulty = ?6  where c.id = ?7")
	int updateCourseById(String name, Date start, Date end, String tags, String description, char difficulty, int id);
}
