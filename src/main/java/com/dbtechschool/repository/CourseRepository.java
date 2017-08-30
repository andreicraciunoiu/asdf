package com.dbtechschool.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dbtechschool.model.Course;
import com.dbtechschool.model.User;

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
	@Query(value = "select * from courses c, users u, sections s, days d where u.id_user = ?1 and c.ID_COURSE = d.id_course and d.id_day = s.id_day and s.trainer = CONCAT(u.firstname , ' ', u.lastname)", nativeQuery = true)
	List<Course> getCoursesByTrainerId(Long id);
	
	@Transactional
	@Query(value = "select * from courses where ID_COURSE not in (select ee.ID_COURSE from enrollments ee where ee.id_user=?1)", nativeQuery = true)
	List<Course> getUnenrolledCourses(Long id);
	
	@Transactional
	@Query("select u from User u where u.id = ?1")
	User getUser(Long id);
	
	@Transactional
	@Query("select c from Course c order by c.start ASC")
	List<Course> getCourses();
}
