package com.dbtechschool.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dbtechschool.model.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

	@Modifying
	@Transactional
	@Query("update Course c set c.name = ?1, c.start = ?2, c.end = ?3, c.tags = ?4, c.description = ?5, c.difficulty = ?6  where c.id = ?7")
	int updateCourseById(String name, Date start, Date end, String tags, String description, char difficulty, Long id);
	
	@Transactional
	@Query("select c from Course c, Enrollment e, User u where u.id = ?1 and u.id = e.user.id and e.course.id = c.id")
	List<Course> getCoursesByUserId(Long id);
	
	@Transactional
	@Query("select s.trainer from Course c, Section s, Day d where c.id = ?1 and c.id = d.course.id and d.id = s.day.id")
	List<String> getTrainersByCourseId(Long id);

	@Transactional
	@Query("select c from Course c, Day d, Section s, User u where u.id = ?1 and c.id = d.course.id and d.id = s.day.id and s.trainer = u.firstName + ' ' + u.lastName")
	List<Course> getCoursesByTrainerId(Long id);
}
